package com.meleva.aplicacao.config;

import com.meleva.aplicacao.config.filters.AuthenticationFilter;
import com.meleva.service.pessoa.AuthenticationService;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sabrina on 26/05/16.
 */
@Configuration
public class FiltersConfiguration {

    @Bean
    public FilterRegistrationBean filterRegistration(AuthenticationFilter authenticationFilter) {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(authenticationFilter);
        registration.addUrlPatterns("/pessoa/*");
        registration.addUrlPatterns("/carro/*");
        registration.setName("authenticationFilter");
        return registration;
    }

    @Bean
    public AuthenticationFilter authenticationFilter(AuthenticationService authenticationService) {
        return new AuthenticationFilter(authenticationService);
    }

}
