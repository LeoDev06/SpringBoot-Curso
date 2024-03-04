package springboot.paradigmaaop.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.paradigmaaop.services.GreetingService;

@RestController
public class GreetingController {

   @Autowired
   private GreetingService greetingServices;

   @GetMapping("/greeting")
   public ResponseEntity<?> greeting() {
      return ResponseEntity
            .ok(Collections.singletonMap("greeting", greetingServices.sayHellow("Leonardo", "Como estas")));
   }
   
   @GetMapping("/greeting-error")
   public ResponseEntity<?> greetingError() {
      return ResponseEntity.ok(Collections.singletonMap("greeting", greetingServices.sayHellowError("Leonardo", "Como estas")));
   }
}
