package springboot.crud.apirestfull.handlerExceptionMessage;

/* 
 * Una clase hereda de RuntimeException cuando se desea 
 * indicar que la excepción representa un error no recuperable que
 * se produce durante la ejecución del programa. Estas excepciones no
 * se comprueban y no se pueden capturar mediante bloques try-catch. 
 * Se consideran errores graves que normalmente detienen la ejecución normal 
 * del programa.
 * 
 * Fines de extender de RuntimeException:
 * Indicar errores no recuperables: 
 * Señalan condiciones anormales que el programa no puede manejar y que probablemente resulten en la terminación del programa.
 * Simplificar la gestión de excepciones: 
 * Evitan la necesidad de comprobar y capturar las excepciones en los bloques try-catch, simplificando el código.
 * Permitir la propagación automática: 
 * Se propagan automáticamente hacia arriba en la pila de llamadas hasta que se encuentra un manejador adecuado o se alcanza el final del programa.
 * 
 * luego de definir lo que necesitamos manejar para darle solucion a una excepcion no controlada, podemos hacer uso
 * de la misma dentro de la logica de negocio dentro de las clases @Services, en este caso se quiere enviar una 
 * excepcion personalizada que sera enviado al constructor de la clase padre (super()) para modificar el mensaje
 * por defecto que entrega Spring Boot
 */
public class ExceptionCustom extends RuntimeException {
   public ExceptionCustom(String message) {
      super(message);
   }

}
