package springboot.crud.apirestfull.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/* 
 * ConstraintValidator 
 * Es una interfaz genérica proporcionada por
 * la biblioteca Bean Validation de Java que se utiliza para validar 
 * campos de objetos. Permite definir lógica personalizada para validar
 * que un campo cumple con una restricción específica.
 * 
 * ConstraintValidator se usa para realizar validaciones más complejas
 * que las que se pueden realizar con las anotaciones de validación estándar 
 * de Java.
 * 
 * ConstraintValidatorContext 
 * Es una interfaz proporcionada por la API 
 * de validación de Java Bean y se utiliza junto con la interfaz ConstraintValidator
 * para una validación personalizada en aplicaciones Spring Boot. 
 * Básicamente, proporciona información contextual y métodos para interactuar con 
 * el proceso de validación.
 */

 
public class RequiredValidation implements ConstraintValidator<IsRequired, String> {

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {
      return (value != null && !value.isEmpty() && !value.isBlank()); // retorna Boolean
   }
}
