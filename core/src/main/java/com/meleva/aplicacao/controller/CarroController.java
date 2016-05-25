package com.meleva.aplicacao.controller;

import com.meleva.modelo.Carro;
import com.meleva.service.pessoa.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sabrina on 16/05/16.
 */
@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    CarroService carroService;

    @RequestMapping(method = RequestMethod.POST)
    public void novo(@RequestBody Carro carro) {
        carroService.cadastro(carro);
    }

    @RequestMapping(value = "/busca", method = RequestMethod.GET)
    public Carro buscar(@RequestParam("email") String email) {
        return carroService.buscaPorEmailMotorista(email)
                .orElse(null);
    }

}
