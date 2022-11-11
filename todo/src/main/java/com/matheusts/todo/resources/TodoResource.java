package com.matheusts.todo.resources;


import com.matheusts.todo.domain.Todo;
import com.matheusts.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//indica que a classe é um controlador
//seta um endpoint inicial para a classe
//localhost:8080/todos/

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/todos")
public class TodoResource {

    @Autowired
    private TodoService service;

    //define o path
    //indica que o metodo retorna um response Entity do tipo Get
    //PathVariable é o valor passado no caminho do GetMapping
    //passa o obj no corpo da requisição
    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id){
        Todo obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/open")
    public ResponseEntity<List<Todo>> listOpen(){
        List<Todo> list = service.findAllOpen();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/close")
    public ResponseEntity<List<Todo>> listClose(){
        List<Todo> list = service.findAllClose();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> listAll(){
        List<Todo> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //postMapping indica que vamos fazer uma requisição do tipo Post no endpoint
    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
        //pode passar body(obj) tambem para aparecer o local do objeto no GET
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo obj){
        Todo newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

}

