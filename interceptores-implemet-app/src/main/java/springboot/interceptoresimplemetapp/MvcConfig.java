package springboot.interceptoresimplemetapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

   /*
    * Implementamos el metodo usando crl . se despliega la lista de metodos
    * de la interfaz WebMvcConfigure, buscamos el metodo addInterceptor esto
    * nos permitira implementar la logica necesaria para registrar el interceptor
    * creado, ahora para poder usar el "registry" y poder registar el interceptor
    * debemos inyectarr la clase "HandlerInterceptor", y con el "@Qualifier"
    * indicamos a spring donde esta la creacion de nuestro interceptor
    * "calendarInterceptor"
    */

   @Autowired
   @Qualifier("calendarInterceptor")
   private HandlerInterceptor calendar;

   @SuppressWarnings("null")
   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      //Colocar la ruta base "/api" si es que tiene y la ruta donde se ejecutara el interceptor "/foo"
      registry.addInterceptor(calendar).addPathPatterns("/app/foo");
   }

}
