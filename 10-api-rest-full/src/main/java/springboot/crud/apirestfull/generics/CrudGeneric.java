package springboot.crud.apirestfull.generics;

import java.util.List;

/* 
 * Esta es una interfaz generica, lo que hace es resivir cualquier tipo 
 * de clase @Entity, en este caso si tuvieramos mas de una entidad en 
 * nuestro package entities, esta interfaz generica permitiria crear
 * metodos crud en base a una @Entity en especifico, esto con el fin de
 * evitar tener que crear inicesariamente tantos crud como entidades, 
 * Permitiendo lograr un código más flexible, reutilizable y desacoplado.
 */

public interface CrudGeneric<T> {

   public T save(T entity);

   public T edit(Integer id, T entity);

   public void delete(Integer id);

   public T findById(Integer id);

   public List<T> findAll();
}
