package com.matheusts.todo.repositories;

import com.matheusts.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//informa ao Spring que é um repositorio e adiciona o JPA
// passa o tipo primitivo do identificador do objeto
public interface TodoRepository extends JpaRepository <Todo, Integer>{

   //cria um metodo de busca no banco de dados por objetos que nao estao finalizados
    @Query("SELECT obj FROM Todo obj WHERE obj.finalizado = false ORDER BY obj.dataParaFinalizar")
    List<Todo> findAllOpen();

    @Query("SELECT obj FROM Todo obj WHERE obj.finalizado = true ORDER BY obj.dataParaFinalizar")
    List<Todo> findAllClose();
}
