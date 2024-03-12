package springboot.jpa.asociacionesoantomanymanytoonejpa.generics;

import springboot.jpa.asociacionesoantomanymanytoonejpa.dto.Message;

public class MessageGeneric<T> {

   private T entity;
   private Message message;

   public MessageGeneric(T entity, Message message) {
      this.entity = entity;
      this.message = message;
   }

   public T getEntity() {
      return entity;
   }

   public void setEntity(T entity) {
      this.entity = entity;
   }

   public Message getMessage() {
      return message;
   }

   public void setMessage(Message message) {
      this.message = message;
   }
}
