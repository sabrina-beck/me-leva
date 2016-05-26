package com.meleva.aplicacao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @author sabrina on 26/05/16.
 */
@Component
public class SecurityInfo {

    @Value("${security.meleva.signatura-key}")
    private String signatureKey;

    @Value("${security.meleva.issuer.name}")
    private String issuer;

    @Value("${security.meleva.token-expiration-time.minutes}")
    private Long tokenExpirationInMinutes;

    public String getSignatureKey() {
        return signatureKey;
    }

    public String getIssuer() {
        return issuer;
    }

    public Duration getTokenExpirationInMinutes() {
        return Duration.ofMinutes(tokenExpirationInMinutes);
    }
}
