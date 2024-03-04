package leodev.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

   @Autowired
   @Qualifier("timeInterceptors")
   private HandlerInterceptor timeInterceptor;

   @SuppressWarnings("null")
   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      // ? Incluye la ejecucion del interceptor creado para las rutas definidas
      // "/app/**" -> significa que agregara o excluira segun el contexto los
      // interceptores a todas las rutas dentro de /app
      // registry.addInterceptor(timeInterceptor).addPathPatterns("/app/foo",
      // "/app/baz");

      // ? Excluye la ejecucion del interceptor creado para las rutas definidas
      registry.addInterceptor(timeInterceptor).excludePathPatterns("/app/foo", "/app/baz");
   }

}
