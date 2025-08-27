package com.lastchain.legacynft.global.error;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.OffsetDateTime;
import java.util.Map;

@Hidden
@RestControllerAdvice(basePackages = "com.lastchain.legacynft.api")
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApi(ApiException e) {
        var c = e.getCode();
        return ResponseEntity.status(c.status).body(Map.of(
                "timestamp", OffsetDateTime.now().toString(),
                "status", c.status.value(),
                "error", c.status.getReasonPhrase(),
                "message", c.message
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValid(MethodArgumentNotValidException e) {
        var fe = e.getBindingResult().getFieldErrors().stream().findFirst().orElse(null);
        var msg = fe != null ? fe.getField()+" "+fe.getDefaultMessage() : "Validation error";
        return ResponseEntity.badRequest().body(Map.of(
                "timestamp", OffsetDateTime.now().toString(),
                "status", 400,
                "error", "Bad Request",
                "message", msg
        ));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handleNoResource(NoResourceFoundException e) {
        return ResponseEntity.status(404).body(Map.of(
                "timestamp", OffsetDateTime.now().toString(),
                "status", 404,
                "error", "Not Found",
                "message", "Resource not found"
        ));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleEtc(Exception e) {
        return ResponseEntity.internalServerError().body(Map.of(
                "timestamp", OffsetDateTime.now().toString(),
                "status", 500,
                "error", "Internal Server Error",
                "message", e.getMessage()
        ));
    }
}

