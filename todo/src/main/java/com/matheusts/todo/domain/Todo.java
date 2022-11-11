package com.matheusts.todo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
public class Todo implements Serializable {

    @Id
    //seta a chave primaria no banco de dado
    //pode passar o nome como parametro caso seja diferente no Banco de Dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //gera o id automaticamente no banco de dados
    private Integer id;
    private String titulo;
    private String descricao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataParaFinalizar;
    private boolean finalizado = false;

}

