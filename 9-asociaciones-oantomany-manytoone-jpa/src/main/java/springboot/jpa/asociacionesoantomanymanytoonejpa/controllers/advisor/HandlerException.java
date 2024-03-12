package springboot.jpa.asociacionesoantomanymanytoonejpa.controllers.advisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import springboot.jpa.asociacionesoantomanymanytoonejpa.dto.Message;
import springboot.jpa.asociacionesoantomanymanytoonejpa.generics.MessageGeneric;
import springboot.jpa.asociacionesoantomanymanytoonejpa.handlerException.ErrorMessageException;

@RestControllerAdvice
public class HandlerException {

   @ExceptionHandler(ErrorMessageException.class)
   public ResponseEntity<?> errorNotFound(ErrorMessageException ex) {

      Message message = new Message();
      message.setCode(HttpStatus.NOT_FOUND.value());
      message.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
      message.setMessage("Operación invalida. ".concat(ex.getMessage()));

      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageGeneric<>(null, message));

   }
}
