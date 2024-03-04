package springboot.interceptoresimplemetapp.interceptors;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CalendarInterceptor implements HandlerInterceptor {

   @Value("${config.calendar.open}")
   private Integer open;

   @Value("${config.calendar.close}")
   private Integer close;

   @SuppressWarnings("null")
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      Calendar calendar = Calendar.getInstance();
      int hour = calendar.get(Calendar.HOUR_OF_DAY);
      System.out.println(hour);

      if (hour >= open && hour < close) {
         StringBuilder messageBuilder = new StringBuilder("Bienvenido al horario de atencion a clientes");
         messageBuilder.append("Atendemos desde las ");
         messageBuilder.append(open);
         messageBuilder.append("hrs. ");
         messageBuilder.append(" hasta las ");
         messageBuilder.append(close);
         messageBuilder.append("hrs. ");
         messageBuilder.append("Gracias por visitarnos");
         request.setAttribute("message", messageBuilder.toString());

         return true;
      }

      ObjectMapper mapper = new ObjectMapper();
      Map<String, String> data = new HashMap<>();
      StringBuilder messageBuilder = new StringBuilder("Acción no permitida: Estas fuera del horario de atención ");
      messageBuilder.append("Por favor, ingrese en el horario de atención empieza desde las ");
      messageBuilder.append(open);
      messageBuilder.append("hrs. ");
      messageBuilder.append(" hasta las ");
      messageBuilder.append(close);
      messageBuilder.append("hrs. ");
      messageBuilder.append("Muchas gracias");
      data.put("message", messageBuilder.toString());
      data.put("date", new Date().toString());

      response.setContentType("application/json");
      response.setStatus(401);
      response.getWriter().write(mapper.writeValueAsString(data));

      return false;
   }

   @SuppressWarnings("null")
   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
         @Nullable ModelAndView modelAndView) throws Exception {

   }

}
