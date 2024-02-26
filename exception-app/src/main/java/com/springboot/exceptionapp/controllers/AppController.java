package com.springboot.exceptionapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exceptionapp.exceptions.UserNotFoundException;
import com.springboot.exceptionapp.models.domain.User;
import com.springboot.exceptionapp.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

   @Autowired
   private UserService service;

   @GetMapping("/")
   public String index() {
      // int value = 200 / 0;
      Integer value = Integer.parseInt("10");
      System.out.println(value);
      return "ok 200";
   }

   @GetMapping("/show/{id}")
   public User showUserById(@PathVariable Integer id) {
      User userFound = service.findById(id).orElseThrow(() -> new UserNotFoundException("User not exist in database"));
      /*
       * if (userFound == null) {
       * throw new UserNotFoundException("User not exist");
       * }
       */
      return userFound;
   }

}
