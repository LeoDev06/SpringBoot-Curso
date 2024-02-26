package springboot.paradigmaaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class GreetingFooAspect {

   private Logger logger = LoggerFactory.getLogger(this.getClass());

   /* 
      ? Metodo que simplifica la implementacion del punto de corte o PointCut
      @Pointcut("execution(String springboot.paradigmaaop.services.GreetingService.sayHellow(..))")
      private void greetingLoggerFooPointCut() {
      }
   */

   @Before("GreetingServicePointCut.greetingLoggerFooPointCut()") // punto de corte
   public void loggerBefore(JoinPoint joinPoint) {
      String method = joinPoint.getSignature().getName();
      String args = Arrays.toString(joinPoint.getArgs());
      logger.info("ANTES: " + method + " invocado con dos parametros " + args);
   }

}
