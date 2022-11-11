package com.matheusts.todo.configuration;

import com.matheusts.todo.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
//cria uma classe de configuração no db
public class TestConfig {

    @Autowired
    private DBService dbService;

    //sempre que este perfil estiver ativo ele instancia a base de dados
    @Bean
    //metodo sera iniciado sempre que uma nova instancia for iniciada
    public boolean instancia() throws ParseException {
        this.dbService.instanciaBaseDeDados();
        return true;
    }

}
