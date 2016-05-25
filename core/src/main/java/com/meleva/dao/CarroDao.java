package com.meleva.dao;

import com.meleva.dao.command.BuscaCarroPorEmailMotoristaCommand;
import com.meleva.dao.command.BuscaPessoaPorEmailCommand;
import com.meleva.dao.command.CriarCarroCommand;
import com.meleva.dao.command.CriarPessoaCommand;
import com.meleva.modelo.Carro;
import com.meleva.modelo.Pessoa;
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
