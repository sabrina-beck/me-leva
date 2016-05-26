package com.meleva.aplicacao.controller;

import com.meleva.service.pessoa.AuthenticationService;
import com.meleva.modelo.Pessoa;
import com.meleva.service.pessoa.PessoaService;
import com.meleva.service.pessoa.results.LoginResult;
import com.meleva.service.pessoa.to.LoginData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sabrina on 26/05/16.
 */
@RestController
@RequestMapping(value = "/")
public class AuthenticationController {

    @Autowired
    PessoaService pessoaService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void novo(@RequestBody Pessoa pessoa) {
        pessoaService.cadastro(pessoa);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(HttpServletResponse response, @RequestBody LoginData loginData) {
        LoginResult result = pessoaService.login(loginData);

        if(result.isSucesso()) {
            response.addCookie(new Cookie(AuthenticationService.AUTH_COOKIE, result.getToken().get()));
        }

        return result.isSucesso();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletResponse response) {
        response.addCookie(new Cookie(AuthenticationService.AUTH_COOKIE, ""));
    }

}
