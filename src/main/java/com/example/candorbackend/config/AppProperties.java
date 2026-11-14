package com.example.candorbackend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app")
public record AppProperties(
        String frontendUrl,
        boolean cookieSecure
) {

    public AppProperties {
        if (frontendUrl == null || frontendUrl.isBlank()) {
            throw new IllegalStateException("app.frontend-url must be set (FRONTEND_URL in prod)");
        }
    }
}
