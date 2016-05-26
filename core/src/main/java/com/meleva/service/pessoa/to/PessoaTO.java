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

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Celular getCelular() {
        return celular;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String email;
        private String nome;
        private String sobrenome;
        private Celular celular;
        private LocalDate dataDeNascimento;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder sobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public Builder celular(Celular celular) {
            this.celular = celular;
            return this;
        }

        public Builder dataDeNascimento(LocalDate dataDeNascimento) {
            this.dataDeNascimento = dataDeNascimento;
            return this;
        }

        public PessoaTO build() {
            return new PessoaTO(email, nome, sobrenome, celular, dataDeNascimento);
        }

    }
}
