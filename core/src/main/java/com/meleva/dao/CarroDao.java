package com.meleva.dao;

import com.meleva.dao.carro.command.BuscaCarroPorEmailMotoristaCommand;
import com.meleva.dao.carro.command.CriarCarroCommand;
import com.meleva.modelo.Carro;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;


public class CarroDao {
    private JdbcTemplate jdbcTemplate;

    public CarroDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void criar(Carro carro) {
        new CriarCarroCommand(jdbcTemplate).accept(carro);
    }

    public Optional<Carro> buscaPorEmailMotorista(String email) {
        return new BuscaCarroPorEmailMotoristaCommand(jdbcTemplate).apply(email);
    }
}
