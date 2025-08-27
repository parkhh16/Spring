package com.lastchain.legacynft.global.error;

import java.time.OffsetDateTime;

public record SimpleErrorResponse(
        OffsetDateTime timestamp,
        int status,
        String error,
        String message,
        String path
) {
    public static SimpleErrorResponse of(int status, String error, String message, String path) {
        return new SimpleErrorResponse(OffsetDateTime.now(), status, error, message, path);
    }
}
