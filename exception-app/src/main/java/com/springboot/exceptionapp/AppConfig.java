package com.springboot.exceptionapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.exceptionapp.models.domain.User;

@Configuration
public class AppConfig {

   @Bean
   List<User> users() {
   List<User> users = new ArrayList<>();
      users.add(new User(1, "Leonardo", "Ojeda"));
      users.add(new User(2, "Leila", "Bernal"));
      users.add(new User(3, "Juan", "Ojeda"));
      users.add(new User(4, "Stiben", "Ojeda"));
      users.add(new User(5, "Ingrid", "Caicedo"));

      return users;
   }
   
}
