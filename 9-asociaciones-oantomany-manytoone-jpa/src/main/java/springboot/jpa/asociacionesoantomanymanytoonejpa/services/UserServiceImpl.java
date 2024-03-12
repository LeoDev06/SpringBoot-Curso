package springboot.jpa.asociacionesoantomanymanytoonejpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.jpa.asociacionesoantomanymanytoonejpa.entities.Rol;
import springboot.jpa.asociacionesoantomanymanytoonejpa.entities.User;
import springboot.jpa.asociacionesoantomanymanytoonejpa.handlerException.ErrorMessageException;
import springboot.jpa.asociacionesoantomanymanytoonejpa.repositories.RolRespository;
import springboot.jpa.asociacionesoantomanymanytoonejpa.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

   private final UserRepository repository;
   private final RolRespository rolRepository;

   public UserServiceImpl(UserRepository repository, RolRespository rolRepository) {
      this.repository = repository;
      this.rolRepository = rolRepository;
   }

   @Override
   @Transactional
   public User save(User user, Long rolId) {
      if (user != null && !repository.existsByName(user.getName()) && rolId != null) {
         Optional<Rol> rol = rolRepository.findById(rolId);

         if (rol.isEmpty()) {
            throw new ErrorMessageException("No se pudo crear, el rol no existe");
         }

         user.getRols().add(rol.get());
         return repository.save(user);

      } else {
         throw new ErrorMessageException("No se pudo crear, el usuario ya existe en la base de datos");
      }
   }

   @Override
   @Transactional
   public User edit(Long id, User user) {
      if (id != null && user != null && repository.existsById(id)) {
         user.setId(id);
         return repository.save(user);
      } else {
         throw new ErrorMessageException("No se pudo actualizar, no se encontro ninguna coincidencia");
      }
   }

   @Override
   @Transactional
   public void delete(Long id) {
      if (id != null && repository.existsById(id)) {
         repository.deleteById(id);
      } else {
         throw new ErrorMessageException("No se pudo eliminar, no se encontro alguna coincidencia");
      }

   }

   @Override
   @Transactional(readOnly = true)
   public User findById(Long id) {
      if (id != null && repository.existsById(id)) {
         return repository.findById(id).orElseThrow();
      } else {
         throw new ErrorMessageException("No se encontro ninguna coincidencia");
      }
   }

   @Override
   @Transactional(readOnly = true)
   public List<User> findAll() {
      List<User> listUser = (List<User>) repository.findAll();
      if (!listUser.isEmpty()) {
         return listUser;
      } else {
         throw new ErrorMessageException("Actualmente no hay datos que mostrar");
      }
   }

   @Override
   public User save(User entity) {
      throw new UnsupportedOperationException("Unimplemented method 'save'");
   }

   @Override
   public User edit(User user, Long idRol) {

      // primero consultamos si el usuario existe en bd

      if (idRol != null && user != null && user.getId() != null && user.getId() != null) {

         @SuppressWarnings("null")
         Optional<User> userDB = this.repository.findById(user.getId());
         Optional<Rol> rol = rolRepository.findById(idRol);

         if (rol.isEmpty() || userDB.isEmpty()) {
            throw new ErrorMessageException("No se pudo crear, el rol no existe");
         }

         // extraemos el objeto del optional
         User userEdit = userDB.get();

         // validación si el campo entrante cambia frente al existente
         String name = userEdit.getName() != user.getName() ? user.getName() : userEdit.getName();
         String lastName = userEdit.getLastName() != user.getLastName() ? user.getLastName() : userEdit.getLastName();

         // llenamos la información a editar
         userEdit.setLastName(lastName);
         userEdit.setName(name);
         userEdit.getRols().add(rol.get());

         return repository.save(userEdit);
      } else {
         throw new ErrorMessageException("No se pudo actualizar, no se encontro ninguna coincidencia");
      }
   }

}
