package springboot.jpa.eventosprepostpersistencia.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springboot.jpa.eventosprepostpersistencia.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

   @Query("select u.name from User u where u.name=?1")
   public User findByName(String name);

   public boolean existsByName(String name);
}
