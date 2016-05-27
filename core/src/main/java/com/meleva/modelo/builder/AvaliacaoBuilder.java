package com.meleva.modelo.builder;

import java.time.LocalDate;
import java.time.LocalTime;

import com.google.common.base.Preconditions;
import com.meleva.modelo.Avaliacao;

public class AvaliacaoBuilder {
	private String emailAvaliador;
    private LocalDate data;
    private LocalTime horarioDeSaida;
    private String cidade;
    private String placa;
    private String emailMotorista;
    private Float nota;
    private String comentarios;
    
    
	public AvaliacaoBuilder emailAvaliador(String emailAvaliador) {
		this.emailAvaliador = emailAvaliador;
		return this;
	}
    
	public AvaliacaoBuilder data(LocalDate data) {
		this.data = data;
		return this;
	}
	
	public AvaliacaoBuilder horarioDeSaida(LocalTime horarioDeSaida) {
		this.horarioDeSaida = horarioDeSaida;
		return this;
	}
	
	public AvaliacaoBuilder cidade(String cidade) {
		this.cidade = cidade;
		return this;
	}
	
	public AvaliacaoBuilder placa(String placa) {
		this.placa = placa;
		return this;
	}
	
	public AvaliacaoBuilder emailMotorista(String emailMotorista) {
		this.emailMotorista = emailMotorista;
		return this;
	}
	
	public AvaliacaoBuilder nota(Float nota) {
		this.nota = nota;
		return this;
	}
	
	public AvaliacaoBuilder comentarios(String comentarios) {
		this.comentarios = comentarios;
		return this;
	}
    
	public Avaliacao build() {
        Preconditions.checkNotNull(emailAvaliador);
        Preconditions.checkNotNull(data);
        Preconditions.checkNotNull(horarioDeSaida);
        Preconditions.checkNotNull(cidade);
        Preconditions.checkNotNull(placa);
        Preconditions.checkNotNull(emailMotorista);
        Preconditions.checkNotNull(nota);
        Preconditions.checkNotNull(comentarios);

        return new Avaliacao(emailAvaliador, data, horarioDeSaida, cidade, placa, emailMotorista, nota, comentarios);
    }
    
}
