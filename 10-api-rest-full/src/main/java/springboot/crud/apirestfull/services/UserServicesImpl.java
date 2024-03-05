package springboot.crud.apirestfull.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.crud.apirestfull.entities.User;
import springboot.crud.apirestfull.repositories.UserRepository;

@Service
public class UserServicesImpl implements UserServices {

   @Autowired
   private UserRepository repository;

   @Override
   @Transactional
   public User save(User user) {
      if(user != null && !repository.existsByName(user.getName())){
         return repository.save(user);
      }else{
         return null;
      }
   }

   @Override
   @Transactional
   public User edit(Integer id, User user) {
      if (id != null && user != null) {
         user.setId(id);
         return repository.save(user);
      }else{
         return null;
      }
   }

   @Override
   @Transactional
   public void delete(Integer id) {
      if(id != null && repository.existsById(id)){
         repository.deleteById(id);
      } else {
         new Error("no se encontraron coincidencias");
      }
   }

   @Override
   @Transactional(readOnly = true)
   public User findById(Integer id) {
      if(id != null){
         return repository.findById(id).orElseThrow();
      }else{
         return null;
      }
   }

   @Override
   @Transactional(readOnly = true)
   public List<User> findAll() {
      return (List<User>) repository.findAll();
   }

}
