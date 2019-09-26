package com.triad.bots.common;

public class HttpRestResponse {
    private String message;

    public HttpRestResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
