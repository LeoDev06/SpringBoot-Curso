package springboot.jpa.asociacionesoantomanymanytoonejpa.handlerException;

import org.springframework.http.HttpStatus;

import springboot.jpa.asociacionesoantomanymanytoonejpa.dto.Message;
import springboot.jpa.asociacionesoantomanymanytoonejpa.generics.MessageGeneric;

public class MessageException {

   public static <T> MessageGeneric<T> messageSatusOk(T entity, String newMessage) {

      Message message = new Message();
      message.setCode(HttpStatus.OK.value());
      message.setStatus(HttpStatus.OK.getReasonPhrase());
      message.setMessage("Operación exitosa. ".concat(newMessage));

      return new MessageGeneric<T>(entity, message);
   }
}
