package com.matheusts.todo.resources.exceptions;

import com.matheusts.todo.services.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, ServletRequest request){
        //voltar aqui pra entender melhor essa excessão personalizada
        StandardError error = new StandardError(System.currentTimeMillis(),
                                                HttpStatus.NOT_FOUND.value(),
                                                e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
