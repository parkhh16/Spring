package com.lastchain.legacynft.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lastchain.legacynft.global.error.SimpleErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

import static com.lastchain.legacynft.global.security.JwtAuthenticationFilter.AUTH_ERR_ATTR;

public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper om = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res,
                         org.springframework.security.core.AuthenticationException ex) throws IOException {

        AuthError cause = (AuthError) req.getAttribute(AUTH_ERR_ATTR);
        String message = switch (cause) {
            case MISSING_TOKEN -> "Authorization header missing";
            case MALFORMED_TOKEN -> "Malformed token";
            case EXPIRED_TOKEN -> "Token expired";
            case INVALID_SIGNATURE -> "Invalid token signature";
            case UNSUPPORTED_TOKEN -> "Unsupported token";
            case BLACKLISTED_TOKEN -> "Token revoked";
            default -> "Unauthorized";
        };

        var body = SimpleErrorResponse.of(401, "Unauthorized", message, req.getRequestURI());
        res.setStatus(401);
        res.setContentType("application/json;charset=UTF-8");
        om.writeValue(res.getWriter(), body);
    }
}
