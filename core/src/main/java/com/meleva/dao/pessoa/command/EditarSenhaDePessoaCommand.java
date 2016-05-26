package com.meleva.dao.pessoa.command;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author sabrina on 26/05/16.
 */
public class EditarSenhaDePessoaCommand implements BiConsumer<String, String> {

    private static String UPDATE_SENHA_DE_PESSOA =
            "UPDATE pessoa SET senha = :senha WHERE email = :email";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public EditarSenhaDePessoaCommand(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    @Override
    public void accept(String email, String novaSenha) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("senha", novaSenha);
        parameters.put("email", email);

        jdbcTemplate.update(UPDATE_SENHA_DE_PESSOA, parameters);
    }
}
