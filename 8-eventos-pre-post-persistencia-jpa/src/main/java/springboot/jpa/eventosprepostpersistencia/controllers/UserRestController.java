package springboot.jpa.eventosprepostpersistencia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.jpa.eventosprepostpersistencia.entities.User;
import springboot.jpa.eventosprepostpersistencia.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

   @Autowired
   private UserService service;

   @PostMapping("/create")
   public ResponseEntity<?> saveUser(@RequestBody User user) {
      return ResponseEntity.status(HttpStatus.OK).body(service.save(user));
   }

   @PutMapping("/edit/{id}")
   public ResponseEntity<?> editUser(@PathVariable Integer id, @RequestBody User user) {
      return ResponseEntity.status(HttpStatus.OK).body(service.edit(id, user));
   }

   @GetMapping("/id/{id}")
   public ResponseEntity<?> findById(@PathVariable Integer id) {
      return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
   }

   @GetMapping("/id/{name}")
   public ResponseEntity<?> findByName(@PathVariable String name) {
      return ResponseEntity.status(HttpStatus.OK).body(service.findByName(name));
   }

   @GetMapping("/all")
   public ResponseEntity<?> findAll() {
      return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
   }
}
