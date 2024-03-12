package springboot.jpa.asociacionesoantomanymanytoonejpa.handlerException;

public class ErrorMessageException extends RuntimeException{
   public ErrorMessageException(String message) {
      super(message);
   }
}
