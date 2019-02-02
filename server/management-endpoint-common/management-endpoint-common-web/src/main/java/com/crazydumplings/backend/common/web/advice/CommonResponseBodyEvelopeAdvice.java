package com.crazydumplings.backend.common.web.advice;

import static com.crazydumplings.backend.common.web.GenericMessages.OPERATION_SUCCESSFUL;
import static com.desolatetimelines.utils.lang.StringUtils.nvl;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import java.io.Serializable;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = {"com.crazydumplings.backend.rest", "com.crazydumplings.backend.common.web.rest"})
public class CommonResponseBodyEvelopeAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return new ApiResponse(OK, (Serializable) nvl(body, OPERATION_SUCCESSFUL));
    }

    @ExceptionHandler(org.springframework.security.access.AccessDeniedException.class)
    @ResponseBody
    @ResponseStatus(UNAUTHORIZED) // this can also be set to the exception itself
    public ApiResponse handleAccessDeniedExceptions(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        return new ApiResponse(UNAUTHORIZED, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ApiResponse handleOtherExceptions(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        String violation = getPotentialConstraintViolation(ex.getCause());
        return new ApiResponse(INTERNAL_SERVER_ERROR, (Serializable)nvl(ex.getMessage() + (violation == null ? "" : ": " + violation), ex.getClass().getName()));
    }

    private static String getPotentialConstraintViolation(Throwable ex) {
        if (ex == null) {
            return null;
        }

        if (ex instanceof ConstraintViolationException) {
            ConstraintViolationException cvEx = (ConstraintViolationException) ex;
            Set<ConstraintViolation<?>> violations = cvEx.getConstraintViolations();

            if (violations == null) {
                return null;
            }

            for(ConstraintViolation<?> violation : violations) {
                return violation.getMessage();
            }
        }

        return null;
    }
}
