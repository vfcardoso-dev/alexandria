package com.andurasoftware.alexandria.business.infra.wrappers;

public class StringWrapper {

    private String message;

    public StringWrapper(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
