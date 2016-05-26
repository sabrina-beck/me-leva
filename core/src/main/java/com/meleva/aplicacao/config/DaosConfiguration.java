package com.meleva.aplicacao.config;

import com.meleva.dao.carro.CarroDao;
import com.meleva.dao.pessoa.PessoaDao;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author sabrina on 16/05/16.
 */
@Configuration
public class DaosConfiguration {

    @Bean
    @Autowired
    public DataSource dataSource(DatabaseInfo dbConfig) {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName(dbConfig.getDiverClass());
        dataSource.setJdbcUrl(dbConfig.getJdbcUrl());
        dataSource.setUsername(dbConfig.getUsername());
        dataSource.setPassword(dbConfig.getPassword());
        dataSource.setConnectionTestQuery(dbConfig.getConnectionTestQuery());
        dataSource.setMaximumPoolSize(dbConfig.getMaximumPoolSize());

        return dataSource;
    }

    @Bean
    @Autowired
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Autowired
    public PessoaDao pessoaDao(JdbcTemplate jdbcTemplate) {
        return new PessoaDao(jdbcTemplate);
    }

    @Bean
    @Autowired
    public CarroDao carroDao(JdbcTemplate jdbcTemplate) {
        return new CarroDao(jdbcTemplate);
    }

}
