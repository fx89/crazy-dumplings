package com.crazydumplings.backend.security.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.crazydumplings.backend.security.exception.CrazyDumplingsSecurityException;

@Aspect
@Component
public class SecurityServiceExceptionTranslationAspect {
    @Around("execution(* com.crazydumplings.backend.security.SecurityService.*(..))")
    public Object securityServiceExceptionTranslationAdvice(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Throwable exc) {
            throw new CrazyDumplingsSecurityException(exc.getMessage(), (Exception) exc);
        }
    }
}