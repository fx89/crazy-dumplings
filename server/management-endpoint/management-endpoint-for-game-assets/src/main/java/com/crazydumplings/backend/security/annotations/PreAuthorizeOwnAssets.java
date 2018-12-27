package com.crazydumplings.backend.security.annotations;

import static com.crazydumplings.backend.security.annotations.AssetType.REPO_ID;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This method-level annotation specifies that the method should not be allowed to run unless the element modified by the method is owned by the
 * calling authority
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PreAuthorizeOwnAssets {
    AssetType assetType() default REPO_ID;
}
