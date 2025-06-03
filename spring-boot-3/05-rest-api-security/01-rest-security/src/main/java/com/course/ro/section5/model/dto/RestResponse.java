package com.course.ro.section5.model.dto;

import org.springframework.http.HttpStatus;

public class RestResponse<T> {

    private String message;
    private int statusCode;
    private String statusName;
    private long timestamp;
    private boolean success;
    private T data;

    public RestResponse(String message, HttpStatus status, boolean success) {
        this.message = message;
        this.statusCode = status.value();
        this.statusName = status.name();
        this.timestamp = System.currentTimeMillis();
        this.success = success;
    }

    public RestResponse(String message, HttpStatus status, T data, boolean success) {
        this(message, status, success);
        this.data = data;
    }

    public RestResponse(HttpStatus status, T data, boolean success) {
        this("", status, data, success);
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

}
