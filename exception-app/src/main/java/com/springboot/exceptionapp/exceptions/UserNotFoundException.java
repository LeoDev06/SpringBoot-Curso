package com.springboot.exceptionapp.exceptions;

public class UserNotFoundException extends RuntimeException {

   public UserNotFoundException(String message){
      super(message);
   }
}
