package com.meleva.dao.carro.command;

import com.meleva.modelo.Carro;
import com.meleva.modelo.Celular;
import com.meleva.modelo.Pessoa;
import com.meleva.modelo.builder.CarroBuilder;
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

public class BuscaCarroPorEmailMotoristaCommand implements Function<String, Optional<Carro>> {

    private static final String SELECT_CARRO_POR_EMAIL = "SELECT * FROM carro WHERE email_motorista = :email";

    private NamedParameterJdbcTemplate jdbcTemplate;

    public BuscaCarroPorEmailMotoristaCommand(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    public Optional<Carro> apply(String email) {
        Map<String, Object> parameters = new HashMap();
        parameters.put("email", email);

        try {
            return Optional.of(jdbcTemplate.queryForObject(SELECT_CARRO_POR_EMAIL, parameters, new RowMapper<Carro>() {
                public Carro mapRow(ResultSet rs, int i) throws SQLException {
                    return new CarroBuilder()
                            .cidade(rs.getString("cidade"))
                            .placa(rs.getString("placa"))
                            .emailMotorista(rs.getString("email_motorista"))
                            .modelo(rs.getString("modelo"))
                            .cor(rs.getString("cor"))
                            .build();
                }
            }));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
