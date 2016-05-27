package com.meleva.dao.carro.command;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.meleva.modelo.Avaliacao;
import com.meleva.modelo.builder.AvaliacaoBuilder;

public class BuscaAvaliacaoPorPassageiro implements Function<String, Optional<Avaliacao>> {

    private static final String SELECT_AVALIACAO_POR_PASSAGEIRO = "SELECT * FROM avaliacao WHERE emailAvaliador = :email";

    private NamedParameterJdbcTemplate jdbcTemplate;

    public BuscaAvaliacaoPorPassageiro(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    public Optional<Avaliacao> apply(String email) {
        Map<String, Object> parameters = new HashMap();
        parameters.put("email", email);

        try {
            return Optional.of(jdbcTemplate.queryForObject(SELECT_AVALIACAO_POR_PASSAGEIRO, parameters, new RowMapper<Avaliacao>() {
                public Avaliacao mapRow(ResultSet rs, int i) throws SQLException {
                    return new AvaliacaoBuilder()
                            .emailAvaliador(rs.getString("cidade"))
                            .cidade(rs.getString("cidade"))
                            .placa(rs.getString("placa"))
                            .emailMotorista(rs.getString("emailMotorista"))
                            .nota(rs.getFloat("nota"))
                            .comentarios(rs.getString("comentarios"))
                            .build();
                }
            }));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

}
