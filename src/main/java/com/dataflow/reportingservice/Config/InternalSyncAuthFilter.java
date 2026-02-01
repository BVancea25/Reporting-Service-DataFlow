package com.dataflow.reportingservice.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class InternalSyncAuthFilter extends OncePerRequestFilter {

    @Value("${internal.sync.api-key}")
    private String expectedKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if(request.getRequestURI().startsWith("/api/transactions")){
            String apiKey = request.getHeader("X-REPORTING-API-KEY");

            if(!expectedKey.equals(apiKey)){
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return;
            }
        }

        filterChain.doFilter(request, response);

    }
}
