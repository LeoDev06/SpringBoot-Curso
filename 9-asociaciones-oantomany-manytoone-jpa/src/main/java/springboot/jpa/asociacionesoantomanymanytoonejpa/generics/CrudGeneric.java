package springboot.jpa.asociacionesoantomanymanytoonejpa.generics;

import java.util.List;

public interface CrudGeneric<T, ID> {

   public T save(T entity);

   public T edit(ID id, T entity);

   public void delete(ID id);

   public T findById(ID id);

   public List<T> findAll();
}
