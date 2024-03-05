package springboot.crud.apirestfull.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import springboot.crud.apirestfull.entities.User;
import springboot.crud.apirestfull.handlerExceptionMessage.HandlerExeption;
import springboot.crud.apirestfull.handlerExceptionMessage.ResultException;
import springboot.crud.apirestfull.services.UserServices;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

   @Autowired
   private UserServices service;

   @PostMapping("/create")
   public ResponseEntity<?> saveUser(@Valid @RequestBody User user, BindingResult result) {
      
      if (result.hasFieldErrors()) {
         return ResultException.validation(result);
      }

      User userSave = service.save(user);
      if(userSave != null){
         return ResponseEntity.status(HttpStatus.OK).body(HandlerExeption.statusOk(userSave, "Se creo correctamente"));
      }else{
         return ResponseEntity.status(HttpStatus.OK).body(HandlerExeption.statusNotFound(user, "usuario ya registrado"));
      }
   }

   @PutMapping("/edit/{id}")
   public ResponseEntity<?> editUser(@PathVariable Integer id, @Valid @RequestBody User user, BindingResult result) {
      return null;
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
      return null;
   }

   @GetMapping("/id/{id}")
   public ResponseEntity<?> findUserById(@PathVariable Integer id) {
      return null;
   }

   @GetMapping("/all")
   public ResponseEntity<?> findAllUser() {
      return null;
   }
}
