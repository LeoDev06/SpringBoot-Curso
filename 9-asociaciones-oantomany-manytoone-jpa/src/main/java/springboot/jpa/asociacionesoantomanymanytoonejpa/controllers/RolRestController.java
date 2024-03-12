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
import springboot.jpa.asociacionesoantomanymanytoonejpa.entities.Rol;
import springboot.jpa.asociacionesoantomanymanytoonejpa.handlerException.BindingResultException;
import springboot.jpa.asociacionesoantomanymanytoonejpa.handlerException.MessageException;
import springboot.jpa.asociacionesoantomanymanytoonejpa.services.RolService;

@RestController
@RequestMapping("/api/rol")
public class RolRestController {

   private RolService service;

   public RolRestController(RolService service) {
      this.service = service;
   }

   @PostMapping("/create")
   public ResponseEntity<?> createRol(@Valid @RequestBody Rol rol, BindingResult result) {
      if (result.hasFieldErrors()) {
         return BindingResultException.validation(result);
      }
      Rol rolSave = service.save(rol);
      return ResponseEntity.status(HttpStatus.OK)
            .body(MessageException.messageSatusOk(rolSave, "Rol creado correctamente"));
   }

   @PutMapping("/edit/{id}")
   public ResponseEntity<?> editRol(@PathVariable Long id, @RequestBody Rol rol, BindingResult result) {
      if (result.hasFieldErrors()) {
         return BindingResultException.validation(result);
      }

      rol.setId(id);
      Rol rolUpdate = service.save(rol);
      return ResponseEntity.status(HttpStatus.OK)
            .body(MessageException.messageSatusOk(rolUpdate, "Rol actualizado correctamente"));
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> deleteRol(@PathVariable Long id) {
      service.delete(id);
      return ResponseEntity.status(HttpStatus.OK)
            .body(MessageException.messageSatusOk(null, "Rol eliminado correctamente"));
   }

   @GetMapping("/id/{id}")
   public ResponseEntity<?> rolFindById(@PathVariable Long id) {
      Rol rol = service.findById(id);
      return ResponseEntity.status(HttpStatus.OK)
            .body(MessageException.messageSatusOk(rol, "Se encontro una coincidencia"));
   }

   @GetMapping("/all")
   public ResponseEntity<?> rolFindAll() {
      List<Rol> rolList = (List<Rol>) service.findAll();
      return ResponseEntity.status(HttpStatus.OK).body(MessageException.messageSatusOk(rolList, "Roles encontrados"));
   }

}
