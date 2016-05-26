package com.meleva.dao.command.pessoa;

import com.meleva.modelo.Celular;
import com.meleva.modelo.Pessoa;
import com.meleva.modelo.builder.PessoaBuilder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author sabrina on 26/05/16.
 */
public class BuscaSenhaDePessoaPorEmail implements Function<String, Optional<String>> {

    private static final String SELECT_SENHA_DE_PESSOA_POR_EMAIL =
            "SELECT senha FROM pessoa WHERE email = :email";

    private NamedParameterJdbcTemplate jdbcTemplate;

    public BuscaSenhaDePessoaPorEmail(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    @Override
    public Optional<String> apply(String email) {
        Map<String, Object> parameters = new HashMap();
        parameters.put("email", email);

        try {
            return Optional.of(jdbcTemplate.queryForObject(SELECT_SENHA_DE_PESSOA_POR_EMAIL, parameters,
                    (rs, i) -> rs.getString("senha")));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}

