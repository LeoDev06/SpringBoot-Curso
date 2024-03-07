package springboot.crud.apirestfull.controllers;

import java.util.List;

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
import springboot.crud.apirestfull.handlerExceptionMessage.ResultException;
import springboot.crud.apirestfull.handlerExceptionMessage.StatusMessage;
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
      return ResponseEntity.status(HttpStatus.OK).body(StatusMessage.messageStatusOk(userSave, "Usuario creado correctamente"));
   }

   @PutMapping("/edit/{id}")
   public ResponseEntity<?> editUser(@PathVariable Integer id, @Valid @RequestBody User user, BindingResult result) {

      if (result.hasFieldErrors()) {
         return ResultException.validation(result);
      }
      User userEdit = service.edit(id, user);
      return ResponseEntity.status(HttpStatus.OK).body(StatusMessage.messageStatusOk(userEdit, "Usuario Actualizado correctamente"));
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
      service.delete(id);
      return ResponseEntity.status(HttpStatus.OK).body(StatusMessage.messageStatusOk(null, "Usuario Eliminado correctamente"));
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> findUserById(@PathVariable Integer id) {
      User userFound = service.findById(id);
      return ResponseEntity.status(HttpStatus.OK).body(StatusMessage.messageStatusOk(userFound, "Se encontro una coincidencia"));
   }

   @GetMapping("/all")
   public List<User> findAllUser() {
      return (List<User>) service.findAll();
   }
}
