package com.crazydumplings.backend.security.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.crazydumplings.backend.security.model.User;

/**
 * Removes the password from the returned object of all methods returning a
 * {@link com.crazydumplings.backend.security.model.User User} as long as they
 * are part of classes which reside in a package named "rest". By convention,
 * all REST controllers need to be kept in packages named "rest". This ensures
 * that clients to the API will not receive the password, even though in its
 * encrypted form.
 */
@Aspect
@Component
public class RestPackagePasswordMaskingAspect {

    @Around("execution(com.crazydumplings.backend.security.model.User *..rest..*.*(..))")
    public User securityServiceExceptionTranslationAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        User user = (User) joinPoint.proceed();
        user.setEncodedPassword("**********");
        return user;
    }

}
