package com.crazydumplings.gameworldregistry.helper;

import java.time.Instant;

/**
 * Generates names for {@link com.crazydumplings.gameworldregistry.model.RegistryItem registry items}. Assures uniqueness.
 */
public class GameWorldRegistryNamingHelper {

    /**
     * Generates a name in the form of baseName-1417601730000. The base name is truncated to 8 characters.
     */
    public static String createTimeBasedName(String baseName) {
        return baseName.substring(0, 7) + "-" + Instant.now().toEpochMilli();
    }

    public static long createTimeBasedId() {
        return Instant.now().toEpochMilli();
    }

    public static void VerifyName(String name) {
        if (name == null)
            throw new IllegalArgumentException("The provided name is null.");

        if (name.trim().length() == 0)
            throw new IllegalArgumentException("The provided name is blank.");
    }
}
