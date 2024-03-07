package springboot.crud.apirestfull.handlerExceptionMessage;

import org.springframework.http.HttpStatus;

import springboot.crud.apirestfull.entities.dto.MessageException;
import springboot.crud.apirestfull.generics.MessageGenericException;

/* 
 * Esta funcion permite manejar un mensaje de tipo status OK, que será implementada dentro
 * del RestController para mostrar cuando se haya cumplido satisfactoriamente algun metodo
 * http o conocidos tambien como metodos handler (puesto que son metodos que los maneja 
 * unicamente el @RestController), con el fin de que sea un mensage personalizado mas 
 * agradable a la vista y facil de entender, esta clase es generica por el hecho de que 
 * resive cualquier tipo de clase @Entity con el fin de optimizar y reducir codigo.
 */
public class StatusMessage {
   
   public static <T> MessageGenericException<T> messageStatusOk(T entity, String defaultMessage) {

      MessageException message = new MessageException();
      message.setCode(HttpStatus.OK.value());
      message.setStatus(HttpStatus.OK.getReasonPhrase());
      message.setDescripton("Operacion exitosa, " + defaultMessage);

      MessageGenericException<T> exception = new MessageGenericException<>();
      exception.setData(entity);
      exception.setMessage(message);

      return exception;
   }
}
