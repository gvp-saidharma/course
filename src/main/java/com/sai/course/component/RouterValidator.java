package com.sai.course.component;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/v2/api-docs",
            "/v3/api-docs",
            "/configuration/ui",
            "/swagger-resources",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars"
    );

    public Predicate<String> isSecured =
            requestURL -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> {
                        return requestURL.contains(uri);
                    });

}