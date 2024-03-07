package springboot.jpa.asociacionesoantomanymanytoonejpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springboot.jpa.asociacionesoantomanymanytoonejpa.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
   
}
