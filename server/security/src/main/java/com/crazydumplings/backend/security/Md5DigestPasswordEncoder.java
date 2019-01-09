package com.crazydumplings.backend.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;

public class Md5DigestPasswordEncoder implements PasswordEncoder {
    private static final MessageDigest md5Digest = createMd5Digest();

    @Override
    public String encode(CharSequence rawPassword) {
        byte[] bytes = md5Digest.digest(rawPassword.toString().getBytes());

        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            strBuf.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return strBuf.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null) {
            return false;
        }

        String encodedRawPassword = encode(rawPassword);
        return encodedRawPassword.equals(encodedPassword);
    }

    private static MessageDigest createMd5Digest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
