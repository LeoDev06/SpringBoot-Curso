package springboot.jpa.eventosprepostpersistencia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.jpa.eventosprepostpersistencia.entities.User;
import springboot.jpa.eventosprepostpersistencia.repositories.UserRepository;

@Service
public class UserServicesImpl implements UserService {

   @Autowired
   private UserRepository repository;

   @Override
   @Transactional
   public User save(User user) {
      if (user != null && !repository.existsByName(user.getName())) {
         return repository.save(user);
      } else {
         return null;
      }
   }

   @Override
   @Transactional
   public User edit(Integer id, User user) {
      if (id != null && user != null) {
         if (repository.existsById(id)) {
            user.setId(id);
            return repository.save(user);
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   @Override
   @Transactional(readOnly = true)
   public User findById(Integer id) {
      if (id != null && repository.existsById(id)) {
         Optional<User> findUser = repository.findById(id);
         return findUser.get();
      } else {
         return null;
      }
   }

   @Override
   @Transactional(readOnly = true)
   public User findByName(String name) {
      if (name != null) {
         User findNameUser = repository.findByName(name);
         return findNameUser;
      } else {
         return null;
      }
   }

   @Override
   @Transactional(readOnly = true)
   public List<User> findAll() {
      return (List<User>) repository.findAll();
   }

}
