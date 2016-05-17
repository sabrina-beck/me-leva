package com.meleva.dao;

import com.meleva.dao.command.BuscaPessoaPorEmailCommand;
import com.meleva.dao.command.CriarPessoaCommand;
import com.meleva.modelo.Pessoa;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

/**
 * @author sabrina on 16/05/16.
 */
public class PessoaDao {
    private JdbcTemplate jdbcTemplate;

    public PessoaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void criar(Pessoa pessoa) {
        new CriarPessoaCommand(jdbcTemplate).accept(pessoa);
    }

    public Optional<Pessoa> buscaPorEmail(String email) {
        return new BuscaPessoaPorEmailCommand(jdbcTemplate).apply(email);
    }
}
