package com.crazydumplings.backend.common.web.advice;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class ApiResponse implements Serializable {

    private HttpStatus     status;
    private Serializable   payload;

    public ApiResponse(HttpStatus status, Serializable payload) {
        this.status = status;
        this.payload = payload;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Serializable getPayload() {
        return payload;
    }

    public void setPayload(Serializable message) {
        this.payload = message;
    }

    public String toString() {
        return "Status " + ((status == null) ? "UNKNOWN" : status.toString());
    }
}