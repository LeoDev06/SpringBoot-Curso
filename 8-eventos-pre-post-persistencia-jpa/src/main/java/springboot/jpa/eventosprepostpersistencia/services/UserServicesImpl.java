package springboot.jpa.eventosprepostpersistencia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.jpa.eventosprepostpersistencia.entities.User;
import springboot.jpa.eventosprepostpersistencia.repositories.UserRepository;

@Service
public class UserServicesImpl implements UserService {

   @Autowired
   private UserRepository repository;

   @Override
   public User findById(Integer id) {
      if (id != null && repository.existsById(id)) {
         Optional<User> findUser = repository.findById(id);
         return findUser.get();
      } else {
         return null;
      }
   }

   @Override
   public User findByName(String name) {
      if (name != null) {
         User findNameUser = repository.findByName(name);
         return findNameUser;
      } else {
         return null;
      }
   }

   @Override
   public List<User> findAll() {
      return (List<User>) repository.findAll();
   }

}
