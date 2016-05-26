package com.meleva.dao.pessoa.command;

import com.meleva.service.pessoa.to.PessoaTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Date;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author sabrina on 26/05/16.
 */
public class EditarPessoaCommand implements Consumer<PessoaTO> {

    private static String UPDATE_PESSOA =
            "UPDATE pessoa " +
                    "SET nome = :nome, sobrenome = :sobrenome, ddi_celular = :ddi_celular, ddd_celular = :ddd_celular, " +
                    "numero_celular = :numero_celular, data_de_nascimento = :data_de_nascimento " +
                    "WHERE email = :email";

    private NamedParameterJdbcTemplate jdbcTemplate;

    public EditarPessoaCommand(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    @Override
    public void accept(PessoaTO pessoa) {
        Date dataDeNascimento = Date.from(pessoa.getDataDeNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant());

        Map<String, Object> parameters = new HashMap();
        parameters.put("email", pessoa.getEmail());
        parameters.put("nome", pessoa.getNome());
        parameters.put("sobrenome", pessoa.getSobrenome());
        parameters.put("ddi_celular", pessoa.getCelular().getDdi());
        parameters.put("ddd_celular", pessoa.getCelular().getDdd());
        parameters.put("numero_celular", pessoa.getCelular().getNumero());
        parameters.put("data_de_nascimento", dataDeNascimento);

        jdbcTemplate.update(UPDATE_PESSOA, parameters);
    }
}
