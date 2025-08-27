package com.lastchain.legacynft.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lastchain.legacynft.global.error.SimpleErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class RestAccessDeniedHandler implements AccessDeniedHandler {
    private final ObjectMapper om = new ObjectMapper();
    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res,
                       org.springframework.security.access.AccessDeniedException ex) throws IOException {
        var body = SimpleErrorResponse.of(403, "Forbidden", "Access denied", req.getRequestURI());
        res.setStatus(403);
        res.setContentType("application/json;charset=UTF-8");
        om.writeValue(res.getWriter(), body);
    }
}
