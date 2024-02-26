package leodev.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leodev.app.models.dtos.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

   @GetMapping("userDetails")
   public UserDto userDetails() {

      UserDto user = new UserDto(
            "Leonardo",
            "Ojeda",
            "leodev@gmail",
            "Este es un mensaje importante");

      return user;
   }

   @GetMapping("/listUsers")
   public List<UserDto> listUsers() {

      UserDto leonardo = new UserDto("Leonardo", "Ojeda", "leo@gmail");
      UserDto ingrid = new UserDto("Ingrid", "Caicedo", "ingrid@gmail");
      UserDto juan = new UserDto("Juan", "Ojeda", "juan@gmail");

      return Arrays.asList(leonardo, ingrid, juan);
   }

}
