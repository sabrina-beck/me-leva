package com.meleva.dao.pessoa;

import com.meleva.dao.pessoa.command.*;
import com.meleva.modelo.Celular;
import com.meleva.modelo.Pessoa;
import com.meleva.service.pessoa.to.PessoaTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Optional;

/**
 * @author sabrina on 16/05/16.
 */
public class PessoaDao {

    public static final RowMapper<PessoaTO> PESSOA_MAPPER = (rs, i) ->
            PessoaTO.builder()
                    .email(rs.getString("email"))
                    .nome(rs.getString("nome"))
                    .sobrenome(rs.getString("sobrenome"))
                    .celular(
                            new Celular(rs.getInt("ddi_celular"), rs.getInt("ddd_celular"), rs.getInt("numero_celular"))
                    )
                    .dataDeNascimento(rs.getTimestamp("data_de_nascimento").toLocalDateTime().toLocalDate())
                    .build();

    private JdbcTemplate jdbcTemplate;

    public PessoaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void criar(Pessoa pessoa) {
        new CriarPessoaCommand(jdbcTemplate).accept(pessoa);
    }

    public Optional<PessoaTO> buscaPorEmail(String email) {
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

    public void editarSenha(String email, String novaSenha) {
        new EditarSenhaDePessoaCommand(jdbcTemplate).accept(email, novaSenha);
    }
}
