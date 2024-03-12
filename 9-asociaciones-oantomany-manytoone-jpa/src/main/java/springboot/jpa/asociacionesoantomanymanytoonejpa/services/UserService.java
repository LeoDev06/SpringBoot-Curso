package springboot.jpa.asociacionesoantomanymanytoonejpa.services;

import springboot.jpa.asociacionesoantomanymanytoonejpa.entities.User;
import springboot.jpa.asociacionesoantomanymanytoonejpa.generics.CrudGeneric;

public interface UserService extends CrudGeneric<User, Long> {
   public User save(User entity, Long idRol);

   public User edit(User entity, Long idRol);
}
