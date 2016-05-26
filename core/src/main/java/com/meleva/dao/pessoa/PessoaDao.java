package com.meleva.dao.pessoa;

import com.meleva.dao.pessoa.command.*;
import com.meleva.modelo.Pessoa;
import com.meleva.service.pessoa.to.PessoaTO;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
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

    public Optional<String> buscaSenha(String email) {
        return new BuscaSenhaDePessoaPorEmail(jdbcTemplate).apply(email);
    }

    public void editar(PessoaTO pessoa) {
        new EditarPessoaCommand(jdbcTemplate).accept(pessoa);
    }


    public List<PessoaTO> listar() {
        return new ListarPessoasCommand(jdbcTemplate).get();
    }
}
