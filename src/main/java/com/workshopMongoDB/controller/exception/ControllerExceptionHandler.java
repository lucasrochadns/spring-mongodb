package com.workshopMongoDB.controller.exception;

import com.sun.jdi.ObjectCollectedException;
import com.workshopMongoDB.domain.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectCollectedException.class)
    public ResponseEntity<StandardError> controllerNotFound(ObjectNotFoundException error, HttpServletRequest request){
        String erro = "Resource Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), status.value(), erro, error.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }


}
