package com.springboot.exceptionapp.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.springboot.exceptionapp.exceptions.UserNotFoundException;
import com.springboot.exceptionapp.models.Error;

@RestControllerAdvice
public class HandlerException {

   @ExceptionHandler(ArithmeticException.class)
   public ResponseEntity<Error> divisionByZero(Exception ex) {

      Error error = new Error();
      error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
      error.setError("ERROR: ArithmeticException, Divición por cero");
      error.setMessage(ex.getMessage());
      error.setDate(new Date());

      // ?Primera Alternativa
      // return ResponseEntity.internalServerError().body(error);
      // ?Segunda Alternativa
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
   }

   @ExceptionHandler(NoHandlerFoundException.class)
   public ResponseEntity<Error> notFoundException(NoHandlerFoundException ex) {

      Error error = new Error();
      error.setStatus(HttpStatus.NOT_FOUND.value());
      error.setError("ERROR: ApiRest no encontrado");
      error.setMessage(ex.getMessage());
      error.setDate(new Date());

      return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
   }

   @ExceptionHandler(NumberFormatException.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   public Map<String, Object> numberFormatException(Exception ex) {
      Map<String, Object> error = new HashMap<>();
      error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
      error.put("error", "Fallo el casteo de la variable");
      error.put("message", ex.getMessage());
      error.put("date", new Date());
      return error;
   }

   @ExceptionHandler(UserNotFoundException.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   public Map<String, Object> userNotFoundException(Exception ex) {
      Map<String, Object> error = new HashMap<>();
      error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
      error.put("error", "Error: User Not Found");
      error.put("message", ex.getMessage());
      error.put("date", new Date());
      return error;
   }
}
