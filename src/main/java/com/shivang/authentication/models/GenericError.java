package com.shivang.authentication.models;

import java.io.Serializable;

public class GenericError implements Serializable {
    private final int code;
    private final String message;

    public GenericError(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
