package com.meleva.modelo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;

/**
 * Created by caio on 24/05/16.
 */
@JsonSerialize
@JsonDeserialize
public class Mensagem {

    private Long id;
    private String emailRemetente;
    private String emalDestinatario;
    private String conteudo;
    private LocalDate data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public String getEmalDestinatario() {
        return emalDestinatario;
    }

    public void setEmalDestinatario(String emalDestinatario) {
        this.emalDestinatario = emalDestinatario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
