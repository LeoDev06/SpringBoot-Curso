package leodev.springboot.app.interceptors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptors")
public class LoadingTimeInterceptors implements HandlerInterceptor {

   private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptors.class);

   @SuppressWarnings("null")
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      logger.info("LoadingTimeInterceptor: preHandle() entrando...");

      long start = System.currentTimeMillis();
      request.setAttribute("start", start);

      Random random = new Random();
      int delay = random.nextInt(500);
      Thread.sleep(delay);
      return true;
   }

   @SuppressWarnings("null")
   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
         @Nullable ModelAndView modelAndView) throws Exception {

      HandlerMethod method = ((HandlerMethod) handler);
      long end = System.currentTimeMillis();
      long start = (long) request.getAttribute("start");

      long result = end - start;
      logger.info("Tiempo transcurrido: " + result + " ---> mls");
      logger.info("LoadingTimeInterceptor: postHandle() saliendo..." + method.getMethod().getName());
   }

}
