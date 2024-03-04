package leodev.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import leodev.app.models.dtos.UserDto;

@Controller
public class UserController {

   @GetMapping("/userDetails")
   public String userDetails(Model model) {

      UserDto user = new UserDto("Leonardo", "Ojeda", "leo@gmail.com");

      model.addAttribute("messaje", "Ingeniero en Sistemas");
      model.addAttribute("user", user);

      return "userDetails";
   }

   @GetMapping("/listUsers")
   public String listUsers(ModelMap model) {

      model.addAttribute("title", "Lista de usuarios registrados");
      return "listUsers";
   }

   @ModelAttribute("users")
   public List<UserDto> listUsers() {
      return Arrays.asList(
            new UserDto("Leonardo", "Ojeda", "leo@gmail"),
            new UserDto("Ingrid", "Caicedo", "caicedo@gmail"),
            new UserDto("Juan", "Ojeda", "juan@gmail"));
   }

}
