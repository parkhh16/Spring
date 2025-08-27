package com.lastchain.legacynft.global.error;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad request"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Unauthorized"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "Forbidden"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not found"),
    CONFLICT(HttpStatus.CONFLICT, "Conflict"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Server error");

    public final HttpStatus status;
    public final String message;
    ErrorCode(HttpStatus status, String message) {
        this.status = status; this.message = message;
    }
}
