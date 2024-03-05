package springboot.crud.apirestfull.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springboot.crud.apirestfull.entities.User;

/* 
 * CrudRepository es una interfaz genérica proporcionada por 
 * Spring Data JPA que ofrece operaciones básicas de acceso a datos 
 * para entidades JPA. Es decir, permite realizar operaciones CRUD 
 * (Create, Read, Update, Delete) sobre entidades de una base de datos
 * relacional.
 * 
 * se usa para simplificar el acceso a datos en aplicaciones Spring Boot. 
 * Permite realizar operaciones CRUD sobre entidades sin necesidad de escribir 
 * código SQL o JPA manualmente.
 */

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
   
   public boolean existsByName(String name);
}
