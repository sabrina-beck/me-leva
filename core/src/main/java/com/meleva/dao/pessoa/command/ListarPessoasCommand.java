package com.meleva.dao.pessoa.command;

import com.meleva.dao.PessoaDao;
import com.meleva.modelo.Celular;
import com.meleva.service.pessoa.to.PessoaTO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author sabrina on 26/05/16.
 */
public class ListarPessoasCommand implements Supplier<List<PessoaTO>> {

    private static final String SELECT_PESSOAS =
            "SELECT email, nome, sobrenome, ddi_celular, ddd_celular, numero_celular, data_de_nascimento " +
                    "FROM pessoa";

    private JdbcTemplate jdbcTemplate;

    public ListarPessoasCommand(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PessoaTO> get() {
        try {
            return jdbcTemplate.query(SELECT_PESSOAS, PessoaDao.PESSOA_MAPPER);
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }
}
