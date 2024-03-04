package com.springboot.exceptionapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exceptionapp.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private List<User> users;

   @Override
   public Optional<User> findById(Integer id) {

      /*
       * ? Forma tradicional
       * User userFound = null;
       * for (User user : users) {
       * if (user.getId().equals(id)) {
       * userFound = user;
       * break;
       * }
       * }
       * return Optional.ofNullable(userFound);
       */

      // ? Forma Elegante
      return users.stream().filter(user -> user.getId().equals(id)).findFirst();
   }

   @Override
   public List<User> findAll() {
      return users;
   }

}
