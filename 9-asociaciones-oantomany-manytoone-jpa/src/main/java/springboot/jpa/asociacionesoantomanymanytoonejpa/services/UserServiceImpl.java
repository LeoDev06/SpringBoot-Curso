package springboot.jpa.asociacionesoantomanymanytoonejpa.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.jpa.asociacionesoantomanymanytoonejpa.entities.User;

@Service
public class UserServiceImpl implements UserService {

   @Override
   @Transactional
   public User save(User entiry) {
      return null;
   }

   @Override
   @Transactional
   public User edit(Long id, User entity) {
      return null;
   }

   @Override
   @Transactional
   public void delete(Long id) {

   }

   @Override
   @Transactional(readOnly = true)
   public User findById(Long id) {
      return null;
   }

   @Override
   @Transactional(readOnly = true)
   public List<User> findAll() {
      return null;
   }

}
