package com.springboot.exceptionapp.services;

import java.util.List;
import java.util.Optional;

import com.springboot.exceptionapp.models.domain.User;

public interface UserService {

   Optional<User> findById(Integer id);

   List<User> findAll();

}
