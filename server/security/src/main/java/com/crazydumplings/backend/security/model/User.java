package com.crazydumplings.backend.security.model;

import java.io.Serializable;

public interface User extends Serializable {
    String getFullName();

    void setFullName(String fullName);

    String getUserName();

    void setUserName(String userName);

    String getEncodedPassword();

    void setEncodedPassword(String encodedPassword);

    Long getId();
}
