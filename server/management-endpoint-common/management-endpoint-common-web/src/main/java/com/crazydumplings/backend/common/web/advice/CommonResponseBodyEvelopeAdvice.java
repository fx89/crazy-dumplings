package com.crazydumplings.backend.common.web.advice;

import static com.crazydumplings.backend.common.web.GenericMessages.OPERATION_SUCCESSFUL;
import static com.desolatetimelines.utils.lang.StringUtils.nvl;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import java.io.Serializable;
import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = {"com.crazydumplings.backend.rest"})
public class CommonResponseBodyEvelopeAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
     // Compute the HTTP status:
     // If there's an error, then compute the http status based on the error message, otherwise assume the status is OK
        HttpStatus httpStatus = returnType.getExecutable().getName().equals("error") ? mapExceptionToHttpStatus((Map<String, Object>) body) : OK;

     // Overwrite the response codes
        response.setStatusCode(httpStatus);

     // Return the payload
        return new ApiResponse(httpStatus, (Serializable) nvl(body, OPERATION_SUCCESSFUL));
    }

 // TODO: find out why exception handling doesn't produce any effect even though it's used like in the tutorial: http://www.springboottutorial.com/spring-boot-exception-handling-for-rest-services
    private static HttpStatus mapExceptionToHttpStatus(Map<String, Object> body) {
        String message = (String) body.get("message");

        if (message != null) {
            message = message.toUpperCase();

            if (message.contains("ACCESS") && message.contains("DENIED"))
                return UNAUTHORIZED;
        }

        return HttpStatus.valueOf((Integer) body.get("status"));
    }
}
