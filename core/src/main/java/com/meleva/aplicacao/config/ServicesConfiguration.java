package com.meleva.aplicacao.config;

import com.meleva.dao.CarroDao;
import com.meleva.dao.PessoaDao;
import com.meleva.service.pessoa.AuthenticationService;
import com.meleva.service.pessoa.CarroService;
import com.meleva.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sabrina on 19/05/16.
 */
@Configuration
public class ServicesConfiguration {

    @Bean
    @Autowired
    AuthenticationService authenticationService(SecurityInfo securityInfo) {
        return new AuthenticationService(securityInfo);
    }

    @Bean
    @Autowired
    PessoaService pessoaService(PessoaDao pessoaDao, AuthenticationService authenticationService) {
        return new PessoaService(pessoaDao, authenticationService);
    }

    @Bean
    @Autowired
    CarroService carroService(CarroDao carroDao) {
        return new CarroService(carroDao);
    }

}