package com.matheusts.todo.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardError implements Serializable {

    private Long timeStamp;
    private Integer status;
    private String message;


}