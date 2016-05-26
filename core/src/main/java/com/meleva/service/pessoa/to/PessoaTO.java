package com.meleva.service.pessoa.to;

import com.meleva.modelo.Celular;

import java.time.LocalDate;

/**
 * @author sabrina on 26/05/16.
 */
public class PessoaTO {

    private String email;
    private String nome;
    private String sobrenome;
    private Celular celular;
    private LocalDate dataDeNascimento;

    public PessoaTO() {
    }

    public PessoaTO(String email, String nome, String sobrenome, Celular celular, LocalDate dataDeNascimento) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.celular = celular;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}
