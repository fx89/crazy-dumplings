package com.crazydumplings.backend.security.aspects;

import static com.crazydumplings.backend.utils.SecurityUtils.getCurrentUserId;
import static com.desolatetimelines.utils.aop.AopUtils.getAnnotationFromJoinPoint;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crazydumplings.backend.security.annotations.PreAuthorizeOwnAssets;
import com.crazydumplings.backend.security.exception.CrazyDumplingsGameWorldRegistrySecurityException;
import com.crazydumplings.exception.CrazyDumplingsBadCodingException;

@Aspect
@Component
public class PreAuthorizeOwnAssetsAspect {

    @Autowired
    List<AssetTypeAuthorizer> authorizers;


    @Around("@annotation(com.crazydumplings.backend.security.annotations.PreAuthorizeOwnAssets)")
    public Object authorizeOwnAssets(ProceedingJoinPoint joinPoint) throws Throwable {
     // To authorize access on an asset, one must have at least one authorizer
        if (authorizers == null || authorizers.size() == 0)
            return joinPoint.proceed();

     // Cannot authorize access on a specific asset if a reference to the asset has not been provided.
        if (joinPoint.getArgs() == null || joinPoint.getArgs().length == 0) {
            throwExc(joinPoint.getSignature().toLongString());
        }

     // Get the user ID
        Long userId = getCurrentUserId();

     // Get the annotation object from the join point
        PreAuthorizeOwnAssets preAuthorizeOwnAssets = getAnnotationFromJoinPoint(joinPoint, PreAuthorizeOwnAssets.class);

     // Run through any authorizers
        authorizers.forEach(authorizer -> {
            if (authorizer.getAssetType().equals(preAuthorizeOwnAssets.assetType())) {
                Object supportedArg = getFirstArgOfTypeSupportedByAuthorizer(authorizer, joinPoint.getArgs());

                if (supportedArg == null)
                    throwExc(joinPoint.getSignature().toLongString());

                if (authorizer.authorize(supportedArg, userId) == false)
                    throw new CrazyDumplingsGameWorldRegistrySecurityException("Access to this asset is denied. ");
            }
        });

        return joinPoint.proceed();
    }

    private void throwExc(String joinPointSignature) {
        throw new CrazyDumplingsBadCodingException("A @PreAuthorizeOwnAssets annotation was incorrectly used on [" + joinPointSignature + "]. The join point requires at least one argument of a type that can be handled by the AssetTypeAuthorizer determined by the assetType parameter provided to the annotation. ");
    }

    private static Object getFirstArgOfTypeSupportedByAuthorizer(AssetTypeAuthorizer athorizer, Object[] args) {
        for(Object arg : args)
            if (arg.getClass().equals(athorizer.getAssetTypeClass()))
                return arg;

        return null;
    }

}
