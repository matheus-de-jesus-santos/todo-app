package com.matheusts.todo.services;

import com.matheusts.todo.domain.Todo;
import com.matheusts.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

@Service
//indica ao Spring que é uma classe de serviço
public class DBService {

    //instancia um repositorio, ele gerencia e destroi a aplicação sozinho.
    @Autowired
    private TodoRepository todoRepository;

    public void instanciaBaseDeDados() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11",
                sdf.parse("25/11/2022"), false);

        Todo t2 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11",
                sdf.parse("25/11/2022"), true);

        Todo t3 = new Todo(null, "Teste", "Estudar Spring Boot 2 e Angular 11",
                sdf.parse("25/11/2022"), false);

        Todo t4 = new Todo(null, "Exercitar", "Lorem Ipsum",
                sdf.parse("25/11/2022"), true);

        //salva todos os objetos instanciados no h2
        todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
    }
}
