package springboot.crud.apirestfull.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.crud.apirestfull.entities.User;
import springboot.crud.apirestfull.handlerExceptionMessage.ExceptionCustom;
import springboot.crud.apirestfull.repositories.UserRepository;

@Service
public class UserServicesImpl implements UserServices {

   @Autowired
   private UserRepository repository;

   @Override
   @Transactional
   public User save(User user) {
      if (user != null && !repository.existsByName(user.getName())) {
         return repository.save(user);
      } else {
         throw new ExceptionCustom("No se pudo guardar, el usuario ya existe en la base de datos");
      }
   }

   @Override
   @Transactional
   public User edit(Integer id, User user) {
      if (id != null && user != null && repository.existsById(id)) {
         user.setId(id);
         return repository.save(user);
      } else {
         throw new ExceptionCustom("No se pudo actualizar, no se encontro ninguna coincidencia");
      }
   }

   @Override
   @Transactional
   public void delete(Integer id) {
      if (id != null && repository.existsById(id)) {
         repository.deleteById(id);
      } else {
         throw new ExceptionCustom("No se pudo borrar, no existe alguna coincidencia");
      }
   }

   @Override
   @Transactional(readOnly = true)
   public User findById(Integer id) {
      if (id != null && repository.existsById(id)) {
         return repository.findById(id).orElseThrow();
      } else {
         throw new ExceptionCustom("No se encontro ninguna coincidencia");
      }
   }

   @Override
   @Transactional(readOnly = true)
   public List<User> findAll() {
      List<User> listUser = (List<User>) repository.findAll();
      if (!listUser.isEmpty()) {
         return listUser;
      } else {
         throw new ExceptionCustom("No se encontraron datos para mostrar");
      }
   }

}
