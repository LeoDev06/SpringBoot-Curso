package springboot.crud.apirestfull.handlerExceptionMessage;

import org.springframework.http.HttpStatus;

import springboot.crud.apirestfull.entities.dto.MessageException;
import springboot.crud.apirestfull.generics.MessageGenericException;

public class HandlerExeption {

   public static <T> MessageGenericException<T> statusOk(T entity, String message) {
      MessageException descriptionMessage = new MessageException();
      descriptionMessage.setCode(HttpStatus.OK.value());
      descriptionMessage.setStatus(HttpStatus.OK.getReasonPhrase());
      descriptionMessage.setDescripton("Operacion satisfactoria, " + message);

      MessageGenericException<T> messageOk = new MessageGenericException<T>();
      messageOk.setData(entity);
      messageOk.setMessage(descriptionMessage);

      return messageOk;
   }

   public static <T> MessageGenericException<T> statusNotFound(T entity, String message) {
      MessageException descriptionMessage = new MessageException();
      descriptionMessage.setCode(HttpStatus.NOT_FOUND.value());
      descriptionMessage.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
      descriptionMessage.setDescripton("Operacion Invalida, " + message);

      MessageGenericException<T> messageError = new MessageGenericException<T>();
      messageError.setData(entity);
      messageError.setMessage(descriptionMessage);

      return messageError;
   }
}
