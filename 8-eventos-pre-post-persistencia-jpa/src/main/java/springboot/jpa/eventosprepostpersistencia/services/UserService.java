package springboot.jpa.eventosprepostpersistencia.services;



import java.util.List;

import springboot.jpa.eventosprepostpersistencia.entities.User;

public interface UserService {

   public User save(User user);

   public User edit(Integer id, User user);

   public User findById(Integer id);
   
   public User findByName(String name);

   public List<User> findAll();
}
