package springboot.paradigmaaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointCut {

   /*
    * IMPORTANTE
    * Al declarar un componente mediante la anotacion @Aspect, springBooot
    * lo guarda en memoria, por lo que todos loas @Aspect se guardan en un
    * mismo contenedor, como una lista, por ende al desacoplar los metodos
    * en una clase aparte con un bean de tipo @Aspect obtiene dichos metodos
    * sin necesidad de instanciarlos ya que estan dentro del contexto de los
    * 
    * @Aspect como estan en otra clase los metodos deberan ser publicos, en
    * cambio si estan dentro de la misma clase implementadora deberan ser Privados
    * 
    * se debe tener en cuenta que los puntos de corte en la clase implementadora
    * debe indicar la clase contenedora del los metodos @PointCut seguido 
    * del nombre del metodo ejemplo: "GreetingServicePointCut.greetingLoggerFooPointCut()"
    */

   // ? Metodo que simplifica la implementacion del punto de corte o PointCut
   @Pointcut("execution(String springboot.paradigmaaop.services.GreetingService.sayHellow(..))")
   public void greetingLoggerFooPointCut() {
   }

   // ? Metodo que simplifica la implementacion del punto de corte o PointCut
   @Pointcut("execution(String springboot.paradigmaaop.services.GreetingService.sayHellow(..))") // punto de corte
   public void greetingLoggerPointCut() {
   }
}
