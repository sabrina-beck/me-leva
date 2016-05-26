package com.meleva.service.pessoa;

import com.meleva.service.pessoa.to.PessoaTO;
import com.meleva.dao.PessoaDao;
import com.meleva.modelo.Pessoa;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

/**
 * @author sabrina on 19/05/16.
 */
public class PessoaService {

    private final PessoaDao pessoaDao;

    public PessoaService(PessoaDao pessoaDao) {
        this.pessoaDao = pessoaDao;
    }

    public void cadastro(Pessoa pessoa) {
        String hashedPwd = BCrypt.hashpw(pessoa.getSenha(), BCrypt.gensalt());
        pessoa.setSenha(hashedPwd);
        pessoaDao.criar(pessoa);
    }

    public Optional<PessoaTO> buscaPorEmail(String email) {
        return pessoaDao.buscaPorEmail(email)
                .map(p -> new PessoaTO(p.getEmail(), p.getNome(), p.getSobrenome(), p.getCelular(), p.getDataDeNascimento()));
    }

}
