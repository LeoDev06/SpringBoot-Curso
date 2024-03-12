package springboot.jpa.asociacionesoantomanymanytoonejpa.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.jpa.asociacionesoantomanymanytoonejpa.entities.Rol;
import springboot.jpa.asociacionesoantomanymanytoonejpa.handlerException.ErrorMessageException;
import springboot.jpa.asociacionesoantomanymanytoonejpa.repositories.RolRespository;

@Service
public class RolServiceImpl implements RolService {

   private final RolRespository repository;

   public RolServiceImpl(RolRespository repository) {
      this.repository = repository;
   }

   @Override
   @Transactional
   public Rol save(Rol rol) {
      if (rol != null && !repository.existsByName(rol.getName())) {
         return repository.save(rol);
      } else {
         throw new ErrorMessageException("No se pudo guardar, rol ya existe en la base de datos");
      }
   }

   @Override
   @Transactional
   public Rol edit(Long id, Rol rol) {
      if (id != null && rol != null && repository.existsById(id)) {
         rol.setId(id);
         return repository.save(rol);
      } else {
         throw new ErrorMessageException("No se pudo actualizar, no se encontraron coincidencias");
      }
   }

   @Override
   @Transactional
   public void delete(Long id) {
      if (id != null && repository.existsById(id)) {
         repository.deleteById(id);
      } else {
         throw new ErrorMessageException("No se pudo eliminar, no se encontraron coincidencias");
      }
   }

   @Override
   @Transactional(readOnly = true)
   public Rol findById(Long id) {
      if (id != null && repository.existsById(id)) {
         return repository.findById(id).orElseThrow();
      } else {
         throw new ErrorMessageException("No se encontraron coincidencias");
      }
   }

   @Override
   @Transactional(readOnly = true)
   public List<Rol> findAll() {
      List<Rol> rols = (List<Rol>) repository.findAll();
      if (!rols.isEmpty()) {
         return rols;
      } else {
         throw new ErrorMessageException("No se encontraron datos para mostrar");
      }
   }
}
