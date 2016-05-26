package com.meleva.dao.carro.command;


import com.meleva.modelo.Carro;
import com.meleva.modelo.Pessoa;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Date;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class CriarCarroCommand implements Consumer<Carro> {

    private static String INSERT_CARRO =
            "INSERT INTO carro " +
                    "(cidade, placa, email_motorista, modelo, cor)" +
                    " VALUES (:cidade, :placa, :email_motorista, :modelo, :cor)";

    private NamedParameterJdbcTemplate jdbcTemplate;

    public CriarCarroCommand(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    public void accept(Carro carro) {

        Map<String, Object> parameters = new HashMap();
        parameters.put("cidade", carro.getCidade());
        parameters.put("placa", carro.getPlaca());
        parameters.put("email_motorista", carro.getEmailMotorista());
        parameters.put("modelo", carro.getModelo());
        parameters.put("cor", carro.getCor());

        jdbcTemplate.update(INSERT_CARRO, parameters);
    }
}
