package com.meleva.service.pessoa;

import com.meleva.dao.pessoa.PessoaDao;
import com.meleva.modelo.Pessoa;
import com.meleva.service.pessoa.results.LoginResult;
import com.meleva.service.pessoa.to.LoginData;
import com.meleva.service.pessoa.to.PessoaTO;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
import java.util.Optional;

/**
 * @author sabrina on 19/05/16.
 */
public class PessoaService {

    private final PessoaDao pessoaDao;
    private final AuthenticationService authenticator;

    public PessoaService(PessoaDao pessoaDao, AuthenticationService authenticator) {
        this.pessoaDao = pessoaDao;
        this.authenticator = authenticator;
    }

    public void cadastro(Pessoa pessoa) {
        String hashedPwd = BCrypt.hashpw(pessoa.getSenha(), BCrypt.gensalt());
        pessoa.setSenha(hashedPwd);
        pessoaDao.criar(pessoa);
    }

    public Optional<PessoaTO> buscaPorEmail(String email) {
        return pessoaDao.buscaPorEmail(email);
    }

    public LoginResult login(LoginData loginData) {
        Optional<String> hashedPwd = pessoaDao.buscaSenha(loginData.getEmail());

        if (!hashedPwd.isPresent()) {
            return LoginResult.builder().sucesso(false).build();
        }

        if (!BCrypt.checkpw(loginData.getSenha(), hashedPwd.get())) {
            return LoginResult.builder().sucesso(false).build();
        }

        String token = authenticator.generateToken(loginData.getEmail());

        return LoginResult.builder().sucesso(true).token(token).build();
    }

    public void editar(PessoaTO pessoa) {
        pessoaDao.editar(pessoa);
    }

    public List<PessoaTO> listar() {
        return pessoaDao.listar();
    }
}
