package springboot.jpa.asociacionesoantomanymanytoonejpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springboot.jpa.asociacionesoantomanymanytoonejpa.entities.Rol;

@Repository
public interface RolRespository extends CrudRepository<Rol, Long> {

   public Boolean existsByName(String name);

}
