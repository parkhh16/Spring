package com.lastchain.legacynft.global.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    public static final String AUTH_ERR_ATTR = "AUTH_ERROR";
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {

        String header = req.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            req.setAttribute(AUTH_ERR_ATTR, AuthError.MISSING_TOKEN);
            chain.doFilter(req, res); // EntryPoint가 최종 응답
            return;
        }

        String token = header.substring(7);
        try {
            // TODO: 토큰 파싱/검증 (만료, 서명 등)
            // 검증 성공 시 SecurityContext에 Authentication 세팅
            chain.doFilter(req, res);
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            req.setAttribute(AUTH_ERR_ATTR, AuthError.EXPIRED_TOKEN);
            chain.doFilter(req, res);
        } catch (io.jsonwebtoken.security.SignatureException e) {
            req.setAttribute(AUTH_ERR_ATTR, AuthError.INVALID_SIGNATURE);
            chain.doFilter(req, res);
        } catch (io.jsonwebtoken.MalformedJwtException e) {
            req.setAttribute(AUTH_ERR_ATTR, AuthError.MALFORMED_TOKEN);
            chain.doFilter(req, res);
        } catch (Exception e) {
            req.setAttribute(AUTH_ERR_ATTR, AuthError.UNSUPPORTED_TOKEN);
            chain.doFilter(req, res);
        }
    }
}
