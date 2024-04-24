package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) throws Exception {

        http.authorizeExchange((exchange) -> exchange
                .pathMatchers("/h2-console", "/h2-console/*").permitAll()
                .anyExchange().denyAll());
        return http.build();
    }

    @Bean
    public SecurityFilterChain springSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests((requests) -> requests
                        .requestMatchers(new AntPathRequestMatcher("/h2-console")).permitAll()
                        .anyRequest().permitAll()
                )
                .csrf((csrf) -> csrf
                        .ignoringRequestMatchers(
                                new AntPathRequestMatcher("/h2-console", "/h2-console/*")
                        )

                );
        return http.build();
    }
}
