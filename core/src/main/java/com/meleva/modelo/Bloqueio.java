package com.meleva.modelo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by caio on 24/05/16.
 */
@JsonSerialize
@JsonDeserialize
public class Bloqueio {

    private String emailBloqueador;
    private String emailBloqueado;

    public String getEmailBloqueador() {
        return emailBloqueador;
    }

    public void setEmailBloqueador(String emailBloqueador) {
        this.emailBloqueador = emailBloqueador;
    }

    public String getEmailBloqueado() {
        return emailBloqueado;
    }

    public void setEmailBloqueado(String emailBloqueado) {
        this.emailBloqueado = emailBloqueado;
    }
}
