package com.meleva.aplicacao.controller;

import com.meleva.service.pessoa.PessoaService;
import com.meleva.service.pessoa.to.PessoaTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sabrina on 16/05/16.
 */
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @RequestMapping(value = "/busca", method = RequestMethod.GET)
    public PessoaTO buscar(@RequestParam("email") String email) {
        return pessoaService.buscaPorEmail(email)
                .orElse(null);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void editar(@RequestBody PessoaTO pessoa) {
        pessoaService.editar(pessoa);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<PessoaTO> listar() {
        return pessoaService.listar();
    }

}
