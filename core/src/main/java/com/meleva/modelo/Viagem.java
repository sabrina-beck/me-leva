package com.meleva.modelo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by caio on 24/05/16.
 */
@JsonSerialize
@JsonDeserialize
public class Viagem {

    private String cidade;
    private String placa;
    private String emailMotorista;
    private LocalDate data;
    private LocalTime horarioDeSaida;
    private Integer vagas;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEmailMotorista() {
        return emailMotorista;
    }

    public void setEmailMotorista(String emailMotorista) {
        this.emailMotorista = emailMotorista;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorarioDeSaida() {
        return horarioDeSaida;
    }

    public void setHorarioDeSaida(LocalTime horarioDeSaida) {
        this.horarioDeSaida = horarioDeSaida;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}
