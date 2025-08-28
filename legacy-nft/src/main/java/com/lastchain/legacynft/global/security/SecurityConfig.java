package com.lastchain.legacynft.global.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(cs -> cs.disable());
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/api/health", "/", "/h2-console/**",
                        "/api/wills/**",
                        "/swagger-ui.html","/v3/api-docs/**","/swagger-ui/**",
                        // ⬇️ 캐시 테스트용 엔드포인트 허용
                        "/demo/users/**",
                        // (선택) 캐시 관리 엔드포인트도 열고 싶다면
                        "/admin/cache/**"
                ).permitAll()
                .anyRequest().authenticated()
        );
        http.headers(h -> h.frameOptions(fr -> fr.disable())); // H2 콘솔용

        // 401/403 응답 JSON 지정
        http.exceptionHandling(ex -> ex
                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
                .accessDeniedHandler(new RestAccessDeniedHandler())
        );

        // JWT 필터 연결
//        http.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
