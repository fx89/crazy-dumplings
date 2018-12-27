package com.crazydumplings.backend.security.model;

public interface Permission {
    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);
}
