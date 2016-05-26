package com.meleva.service.pessoa.results;

import java.util.Optional;

/**
 * @author sabrina on 26/05/16.
 */
public class LoginResult {

    private boolean sucesso;
    private Optional<String> token;

    public LoginResult(boolean sucesso, Optional<String> token) {
        this.sucesso = sucesso;
        this.token = token;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public Optional<String> getToken() {
        return token;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private boolean sucesso;
        private Optional<String> token;

        public Builder sucesso(boolean sucesso) {
            this.sucesso = sucesso;
            return this;
        }

        public Builder token(String token) {
            this.token = Optional.of(token);
            return this;
        }

        public LoginResult build() {
            return new LoginResult(sucesso, token);
        }
    }
}
