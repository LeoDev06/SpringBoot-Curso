package springboot.jpa.asociacionesoantomanymanytoonejpa.controllers;

import java.util.List;

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
import springboot.jpa.asociacionesoantomanymanytoonejpa.entities.User;
import springboot.jpa.asociacionesoantomanymanytoonejpa.handlerException.BindingResultException;
import springboot.jpa.asociacionesoantomanymanytoonejpa.handlerException.MessageException;
import springboot.jpa.asociacionesoantomanymanytoonejpa.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

   private final UserService service;

   public UserRestController(UserService service) {
      this.service = service;
   }

   @PostMapping("/create")
   public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result) {
      if (result.hasFieldErrors()) {
         return BindingResultException.validation(result);
      }

      User saveUser = service.save(user);
      return ResponseEntity.status(HttpStatus.OK)
            .body(MessageException.messageSatusOk(saveUser, "El usuario se guardo correctamente"));
   }

   /**
    * new role user create
    * 
    * @param rolId
    * @param user
    * @param result
    * @return
    */
   @PostMapping("/create/{rolId}")
   public ResponseEntity<?> createUserRol(@PathVariable Long rolId, @Valid @RequestBody User user,
         BindingResult result) {
      if (result.hasFieldErrors()) {
         return BindingResultException.validation(result);
      }

      User saveUser = service.save(user, rolId);
      return ResponseEntity.status(HttpStatus.OK)
            .body(MessageException.messageSatusOk(saveUser, "El usuario se guardo correctamente"));
   }

   @PutMapping("/edit/{id}")
   public ResponseEntity<?> editUser(@PathVariable Long id, @Valid @RequestBody User user, BindingResult result) {
      if (result.hasFieldErrors()) {
         return BindingResultException.validation(result);
      }

      user.setId(id);
      User updateUser = service.save(user);
      return ResponseEntity.status(HttpStatus.OK)
            .body(MessageException.messageSatusOk(updateUser, "El usuario se actualizo correctamente"));
   }

   /**
    * Add user role new method
    * 
    * @param id
    * @param user
    * @param result
    * @return
    */
   @PutMapping("/edit/role/{idRol}")
   public ResponseEntity<?> editUserRol(@PathVariable Long idRol, @Valid @RequestBody User user, BindingResult result) {
      if (result.hasFieldErrors()) {
         return BindingResultException.validation(result);
      }

      User updateUser = service.edit(user, idRol);
      return ResponseEntity.status(HttpStatus.OK)
            .body(MessageException.messageSatusOk(updateUser, "El usuario se actualizo correctamente"));
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> deleteUser(@PathVariable Long id) {
      service.delete(id);
      return ResponseEntity.status(HttpStatus.OK)
            .body(MessageException.messageSatusOk(null, "El usuario se elimino correctamente"));
   }

   @GetMapping("/id/{id}")
   public ResponseEntity<?> userFindById(@PathVariable Long id) {
      User userFound = service.findById(id);
      return ResponseEntity.status(HttpStatus.OK)
            .body(MessageException.messageSatusOk(userFound, "Se encontro una coincidencia"));
   }

   @GetMapping("/all")
   public ResponseEntity<?> usersFindAll() {
      return ResponseEntity.status(HttpStatus.OK)
            .body(MessageException.messageSatusOk((List<User>) service.findAll(), "Usuarios encontros"));
   }

}
