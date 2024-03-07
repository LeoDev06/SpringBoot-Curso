package springboot.crud.apirestfull.controllers.controllersAdvicers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import springboot.crud.apirestfull.entities.dto.MessageException;
import springboot.crud.apirestfull.generics.MessageGenericException;
import springboot.crud.apirestfull.handlerExceptionMessage.ExceptionCustom;

/* 
 * El controller Advicer es una anotación que se aplica a
 * una clase para permitir el manejo centralizado de 
 * excepciones. En ese caso:
 * 
 * 1. Mapea una excepcion personalizada que se creo con el nombre de ExceptionCustom.
 * 2. Se resive como argumento de la funcion la expecpión personalizada (ExceptionCustom)
 * 3. se atrapada la excepción mediante la anotacion @ExceptionHandler, dentro de la anotación
 *    @ExceptionHandler definimos la clase ExceptionCustom.class la cual es nuestra clase que 
 *    extiende de RuntimeException. Esta clase es la que maneja las excepciones en la clase @Service
 * 4. Hacemos uso de la instancia de la clase MessageException, para armar un mensage mas puntual
 * 5. Enviamos al ResposeEntity el message (creado por la instancia de la clase MessageException)
 * 6. Usamos la clase generica MessageGenericException para enviar el formato final que tendra
 *    el responseEntity cuando caiga la excepcion
 */

@ControllerAdvice
public class ControllerHandlerException {

   @ExceptionHandler(ExceptionCustom.class)
   public ResponseEntity<Object> notFoundError(ExceptionCustom ex) {

      MessageException message = new MessageException();
      message.setCode(HttpStatus.NOT_FOUND.value());
      message.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
      message.setDescripton(ex.getMessage());

      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageGenericException<>(null, message));
   }
}
