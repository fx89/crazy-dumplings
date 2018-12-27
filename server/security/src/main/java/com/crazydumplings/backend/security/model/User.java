package com.crazydumplings.backend.security.model;

public interface User {
    String getFullName();

    void setFullName(String fullName);

    String getUserName();

    void setUserName(String userName);

    String getEncodedPassword();

    void setEncodedPassword(String encodedPassword);

    Long getId();
}
