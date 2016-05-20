package com.meleva.aplicacao.controller;

import com.meleva.modelo.Pessoa;
import com.meleva.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sabrina on 16/05/16.
 */
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @RequestMapping(method = RequestMethod.POST)
    public void novo(@RequestBody Pessoa pessoa) {
        pessoaService.cadastro(pessoa);
    }

    @RequestMapping(value = "/busca", method = RequestMethod.GET)
    public Pessoa buscar(@RequestParam("email") String email) {
        return pessoaService.buscaPorEmail(email)
                .orElse(null);
    }

}
