package com.meleva.modelo.builder;

import com.google.common.base.Preconditions;
import com.meleva.modelo.Carro;

public class CarroBuilder {

    private String cidade;
    private String placa;
    private String emailMotorista;
    private String cor;
    private String modelo;

    public CarroBuilder cidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public CarroBuilder placa(String placa) {
        this.placa = placa;
        return this;
    }

    public CarroBuilder emailMotorista(String emailMotorista) {
        this.emailMotorista = emailMotorista;
        return this;
    }

    public CarroBuilder cor(String cor) {
        this.cor = cor;
        return this;
    }

    public CarroBuilder modelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public Carro build() {
        Preconditions.checkNotNull(cidade);
        Preconditions.checkNotNull(placa);
        Preconditions.checkNotNull(emailMotorista);
        Preconditions.checkNotNull(cor);
        Preconditions.checkNotNull(modelo);

        return new Carro(cidade, placa, emailMotorista, cor, modelo);
    }

}
