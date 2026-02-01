package com.dataflow.reportingservice.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final InternalSyncAuthFilter internalSyncAuthFilter;

    public SecurityConfig(InternalSyncAuthFilter internalSyncAuthFilter) {
        this.internalSyncAuthFilter = internalSyncAuthFilter;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/api/transactions/**").permitAll()
                                .anyRequest().authenticated()
                        )

                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .addFilterBefore(internalSyncAuthFilter, BearerTokenAuthenticationFilter.class);

        return http.build();
    }
}
