package com.meleva.aplicacao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author sabrina on 16/05/16.
 */
@Component
public class DatabaseConfiguration {

    @Value("${db.meleva.jdbc.url}")
    private String jdbcUrl;

    @Value("${db.meleva.maximum.pool.size}")
    private int maximumPoolSize;

    @Value("${db.meleva.driver.class}")
    private String diverClass;

    @Value("${db.meleva.connection.test.query}")
    private String connectionTestQuery;

    @Value("${db.meleva.username}")
    private String username;

    @Value("${db.meleva.password}")
    private String password;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public String getDiverClass() {
        return diverClass;
    }

    public String getConnectionTestQuery() {
        return connectionTestQuery;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
