package com.meleva.service.pessoa.requests;

/**
 * @author sabrina on 26/05/16.
 */
public class TrocarSenhaRequest {

    private String email;

    private String senhaAntiga;

    private String novaSenha;

    public String getEmail() {
        return email;
    }

    public String getSenhaAntiga() {
        return senhaAntiga;
    }

    public String getNovaSenha() {
        return novaSenha;
    }
}
