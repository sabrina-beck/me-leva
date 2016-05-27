package com.meleva.dao.pessoa.command;

import com.meleva.dao.PessoaDao;
import com.meleva.service.pessoa.to.PessoaTO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author sabrina on 16/05/16.
 */
public class BuscaPessoaPorEmailCommand implements Function<String, Optional<PessoaTO>> {

    private static final String SELECT_PESSOA_POR_EMAIL = "SELECT * FROM pessoa WHERE email = :email";

    private NamedParameterJdbcTemplate jdbcTemplate;

    public BuscaPessoaPorEmailCommand(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    public Optional<PessoaTO> apply(String email) {
        Map<String, Object> parameters = new HashMap();
        parameters.put("email", email);

        try {
            return Optional.of(jdbcTemplate.queryForObject(SELECT_PESSOA_POR_EMAIL, parameters, PessoaDao.PESSOA_MAPPER));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
