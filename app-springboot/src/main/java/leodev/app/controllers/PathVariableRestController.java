package leodev.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leodev.app.models.User;
import leodev.app.models.dtos.ParamsDto;

@RestController
@RequestMapping("/api/path")
public class PathVariableRestController {

   @GetMapping("/variable/{message}")
   public ParamsDto pathMessage(@PathVariable String message) {
      ParamsDto param = new ParamsDto();
      param.setMessage(message);
      return param;
   }

   @GetMapping("/mixVariable/{id}/{message}")
   public ParamsDto mixVariable(@PathVariable Integer id, @PathVariable String message) {
      ParamsDto paramMix = new ParamsDto();
      paramMix.setId(id);
      paramMix.setMessage(message);
      return paramMix;
   }

   /*
    * Para evaluar este caso, es necesario usar postman y generar
    * una peticion Post, luego seleccionar body luego raw y Json
    * Luego insertar
    * 
    * {
    *    "name": "Leonardo",
    *    "lastName": "Ojeda"
    * }
    * 
    * Luego hacer la peticion y esperar la respuesta 200 ok
    */

   @PostMapping("/createUser")
   public User createUser(@RequestBody User user) {
      user.setName(user.getName());
      user.setLastName(user.getLastName());
      return user;
   }

}
