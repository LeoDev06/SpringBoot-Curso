package leodev.springboot.app.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class FooRestController {
   
   @GetMapping("/foo")   
   public Map<String, Object> foo() {
      return Collections.singletonMap("message", "handler foo del controlador");
   }

   @GetMapping("/var")
   public Map<String, Object> var() {
      return Collections.singletonMap("message", "handler var del controlador");
   }

   @GetMapping("/baz")
   public Map<String, Object> baz() {
      return Collections.singletonMap("message", "handler baz del controlador");
   }
}
