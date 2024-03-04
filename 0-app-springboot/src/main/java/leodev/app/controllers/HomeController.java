package leodev.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
   /*
    * Uso de redirec para dos tipos de endPoint
    * { "/", "/home" } y enviara al cliente a "/userDetails"
    */
   @GetMapping({ "/", "/home" })
   public String home() {
      return "redirect:/userDetails";
   }
}
