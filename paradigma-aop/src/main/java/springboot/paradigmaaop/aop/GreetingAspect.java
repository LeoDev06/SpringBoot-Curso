package springboot.paradigmaaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class GreetingAspect {

   private Logger logger = LoggerFactory.getLogger(this.getClass());

   /*
      ? Metodo que simplifica la implementacion del punto de corte o PointCut
      @Pointcut("execution(String springboot.paradigmaaop.services.GreetingService.sayHellow(..))") // punto de corte
      private void greetingLoggerPointCut() {}
   */

   // ! sin @pointCut
   // @Before("execution(String
   // springboot.paradigmaaop.services.GreetingService.sayHellow(..))")
   // ? con @pointCut
   @Before("GreetingServicePointCut.greetingLoggerPointCut()")
   public void loggerBefore(JoinPoint joinPoint) {
      String method = joinPoint.getSignature().getName();
      String args = Arrays.toString(joinPoint.getArgs());
      logger.info("Antes: " + method + " con los argumentos " + args);
   }

   // ! sin @pointCut
   // @After("execution(String
   // springboot.paradigmaaop.services.GreetingService.*(..))")
   // ? con @pointCut
   @After("GreetingServicePointCut.greetingLoggerPointCut()")
   public void loggerAfter(JoinPoint joinPoint) {
      String method = joinPoint.getSignature().getName();
      String args = Arrays.toString(joinPoint.getArgs());
      logger.info("Después: " + method + " con los argumentos " + args);
   }

   // ! sin @pointCut
   // @AfterReturning("execution(String
   // springboot.paradigmaaop.services.GreetingService.sayHellow(..))")
   // ? con @pointCut
   @AfterReturning("GreetingServicePointCut.greetingLoggerPointCut()")
   public void loggerAfterReturning(JoinPoint joinPoint) {
      String method = joinPoint.getSignature().getName();
      String args = Arrays.toString(joinPoint.getArgs());
      logger.info("Returning: " + method + " con los argumentos " + args);
   }

   // ! sin @pointCut
   // @AfterThrowing("execution(String
   // springboot.paradigmaaop.services.GreetingService.sayHellowError(..))")
   // ? con @pointCut
   @AfterThrowing("GreetingServicePointCut.greetingLoggerPointCut()")
   public void loggerAfterThrowing(JoinPoint joinPoint) {
      String method = joinPoint.getSignature().getName();
      String args = Arrays.toString(joinPoint.getArgs());
      logger.info("Throwing: " + method + " con los argumentos " + args);
   }

   // ! sin @pointCut
   // @Around("execution(String springboot.paradigmaaop.services.*.*(..))")
   // ? con @pointCut
   @Around("GreetingServicePointCut.greetingLoggerPointCut()")
   public Object loggerArround(ProceedingJoinPoint joinPoint) throws Throwable {

      String method = joinPoint.getSignature().getName();
      String args = Arrays.toString(joinPoint.getArgs());

      Object result = null;

      try {
         logger.info("El metodo " + method + "() con los parametros " + args);
         result = joinPoint.proceed();
         logger.info("El metodo " + method + "() retorna el resultado: " + result);
         return result;
      } catch (Throwable e) {
         logger.error("Error en la llamada del metodo " + method + "()", e);
         throw e;
      }

   }
}
