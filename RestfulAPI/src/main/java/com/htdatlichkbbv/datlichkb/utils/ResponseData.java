package com.htdatlichkbbv.datlichkb.utils;

public class ResponseData<T> {
    private int code;
    private String message;
    private T Data;

    public ResponseData(Result result) {
        this.code = result.getCode();
        this.message = result.getMessage();
    }

    public ResponseData(int code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        Data = data;
    }

    public ResponseData() {
        super();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}

