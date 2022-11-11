package com.matheusts.todo.services;

import com.matheusts.todo.domain.Todo;
import com.matheusts.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//nidica que é um serviço
public class TodoService {
    //camada de serviços é onde a logica é implementada


    @Autowired
    private TodoRepository repository;

    public Todo findById(Integer id){
        //busque um objeto do tipo Todo no banco de dados
        Optional<Todo> obj = repository.findById(id);
        //orElse = se nao achar retorne nulo
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto nao encontrado! Id: " + id + ", Tipo: " + Todo.class.getName()));
    }

    public List<Todo> findAllOpen() {
        List<Todo> list = repository.findAllOpen();
        return list;
    }

    public List<Todo> findAllClose(){
        List<Todo> list = repository.findAllClose();
        return list;
    }

    public List<Todo> findAll(){
        List<Todo> list = repository.findAll();
        return list;
    }


    public Todo create(Todo obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public String delete(Integer id) {
        repository.deleteById(id);
        return "Objeto excluido com sucesso";
    }

    public Todo update(Integer id, Todo obj) {
        //se achar por id ele seta os parametros do novo objeto ao objeto encontrado
        Todo newObj = findById(id);
        //atribui os valores do antigo objeto ao novo
        newObj.setTitulo(obj.getTitulo());
        newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
        newObj.setDescricao(obj.getDescricao());
        newObj.setFinalizado(obj.isFinalizado());
        return repository.save(newObj);
    }
}
