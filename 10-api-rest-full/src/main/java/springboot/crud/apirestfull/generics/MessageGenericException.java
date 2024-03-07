package springboot.crud.apirestfull.generics;

import springboot.crud.apirestfull.entities.dto.MessageException;

/* 
 * Las clases genéricas son una característica poderosa de Java 
 * que permite crear clases que pueden trabajar con diferentes 
 * tipos de datos sin necesidad de modificar el código. En esta clase
 * en especial, se hace con el fin de resivir cualquier clase @Entity
 * para enviar un mensaje segun la exepcion HttpStatus a tratar, con 
 * el fin de manejar excepciones personalizadas segun nuestra necesidad
 * desde enviar al usuario un status ok(200) o un notfound(404)
 */
public class MessageGenericException<T> {

   private T data;
   private MessageException message;

   public MessageGenericException() {
   }

   public MessageGenericException(T data, MessageException message) {
      this.data = data;
      this.message = message;
   }

   public T getData() {
      return data;
   }

   public void setData(T data) {
      this.data = data;
   }

   public MessageException getMessage() {
      return message;
   }

   public void setMessage(MessageException message) {
      this.message = message;
   }

}
