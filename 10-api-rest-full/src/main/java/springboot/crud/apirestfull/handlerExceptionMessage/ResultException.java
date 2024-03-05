package springboot.crud.apirestfull.handlerExceptionMessage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

/* 
 * Esta clase hace uso del BindingResult que es una clase que depende
 * de la notación @Valid, esta anotacion valida que una clase @Entity 
 * cumpla todas las caracteristicas de su definición, es decir que sus 
 * atributos cumplan frente notaciones de validacion como @NotNull, 
 * @NotEmpty o NotBlanck. En dado caso que no se cumpla, BindingResult
 * atrapara cada excepcion dentro de una lista, esta funcion recorre la 
 * lista e imprime cada excepcion que haya atrapdo el BindingResult. 
 * Final mente podremos enviar un mensage personalizado por cada excepcion
 * atrapada
 */

public class ResultException {
   
   public static ResponseEntity<?> validation(BindingResult result) {
      Map<String, String> errors = new HashMap<>();
      
      result.getFieldErrors().forEach(err -> {
         errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
      });

      return ResponseEntity.badRequest().body(errors);
   } 
}
