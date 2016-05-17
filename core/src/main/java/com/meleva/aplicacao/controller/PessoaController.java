package com.meleva.aplicacao.controller;

import com.meleva.dao.PessoaDao;
import com.meleva.modelo.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author sabrina on 16/05/16.
 */
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaDao pessoaDao;

    @RequestMapping(method = RequestMethod.POST)
    public void buscar(@RequestBody Pessoa pessoa) {
        pessoaDao.criar(pessoa);
    }

    @RequestMapping(value = "/busca", method = RequestMethod.GET)
    public Pessoa buscar(@RequestParam("email") String email) {
        return pessoaDao.buscaPorEmail(email)
                .orElse(null);
    }

}
