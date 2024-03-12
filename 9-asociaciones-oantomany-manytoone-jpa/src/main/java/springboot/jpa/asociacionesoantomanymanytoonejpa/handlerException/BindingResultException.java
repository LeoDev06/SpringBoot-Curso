package springboot.jpa.asociacionesoantomanymanytoonejpa.handlerException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class BindingResultException {

   public static ResponseEntity<?> validation(BindingResult results){
      Map<String, String> errors = new HashMap<>();

      results.getFieldErrors().forEach(error -> {
         errors.put(error.getField(), "El campo " + error.getField() + " " + error.getDefaultMessage());
      });

      return ResponseEntity.badRequest().body(errors);
   }
}
