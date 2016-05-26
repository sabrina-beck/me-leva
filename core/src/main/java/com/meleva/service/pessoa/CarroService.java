package com.meleva.service.pessoa;

import com.meleva.dao.carro.CarroDao;
import com.meleva.modelo.Carro;

import java.util.Optional;


public class CarroService {

    private final CarroDao carroDao;

    public CarroService(CarroDao carroDao) {
        this.carroDao = carroDao;
    }

    public void cadastro(Carro carro) {
        carroDao.criar(carro);
    }

    public Optional<Carro> buscaPorEmailMotorista(String email) {
        return carroDao.buscaPorEmailMotorista(email);
    }

}
