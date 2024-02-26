package springboot.appjpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import springboot.appjpa.dto.PersonDto;
import springboot.appjpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

   List<Person> findByProgrammingLanguage(String programmingLanguage);

   // ? Operador Where in en JPQL
   @Query("select p from Person p where p.id in (1,3,6)")
   public List<Person> getPersonById();
   
   @Query("select p from Person p where p.id in ?1")
   public List<Person> getPersonByIdList(List<Long> ids);
   
   @Query("select p from Person p where p.id not in ?1")
   public List<Person> getPersonByIdListNotIn(List<Long> ids);

   // ? SUBQUERY O SUBCONSULTAS
   @Query("select p.name, length(p.name) from Person p where length(p.name) = (select min(length(p.name)) from Person p)")
   public List<Object[]> getShorterName();

   @Query("select p from Person p where p.id=(select max(p.id) from Person p)")
   public Optional<Person> getLastRegistration();

   // ?Funciones JPQL de agregación count, sum, max, min, avg -> promedio
   @Query("select min(p.id), max(p.id), sum(p.id), avg(length(p.name)), count(p.id) from Person p")
   public Object getResumeAggregationFunction();

   // ? Función JPQL length

   @Query("select p.name, length(p.name) from Person p")
   List<Object[]> getPersonLength();

   @Query("select min(length(p.name)) from Person p")
   Integer getPersonMinLength();

   @Query("select max(length(p.name)) from Person p")
   Integer getPersonMaxLength();

   // ? Funciones JPQL de agregación count, max y min

   @Query("select count(p) from Person p")
   Long totalPerson();

   @Query("select min(p.id) from Person p")
   Long minId();

   @Query("select max(p.id) from Person p")
   Long maxId();

   // ? USO DE BETWEEN and ORDER BY

   List<Person> findByIdBetween(Long id1, Long id2);

   @Query("select new springboot.appjpa.dto.PersonDto(p.name, p.lastName) from Person p where p.id between 2 and 5")
   List<PersonDto> findBetweenById();

   @Query("select new springboot.appjpa.dto.PersonDto(p.name, p.lastName) from Person p where p.id between 2 and 5 order by p.name")
   List<PersonDto> findBetweenOrderById();

   @Query("select new springboot.appjpa.dto.PersonDto(p.name, p.lastName) from Person p where p.id between 2 and 5 order by p.name desc")
   List<PersonDto> findBetweenOrderDescById();

   @Query("select new springboot.appjpa.dto.PersonDto(p.name, p.lastName) from Person p where p.id between 2 and 5 order by p.name Asc")
   List<PersonDto> findBetweenOrderAscById();

   @Query("select p from Person p order by p.id desc")
   List<Person> getAllOrder();

   List<Person> findAllByOrderByNameDesc();

   // ? USO DEL COUNT UPPER and LOWERCASE PARA CONSULTAS QUERY
   @Query("select concat(p.name, ' ', p.lastName) from Person p")
   List<String> findAllFullNameConcat();

   @Query("select p.name || ' ' || p.lastName from Person p")
   List<String> findAllFullNameConcat2();

   @Query("select upper(p.name || ' ' || p.lastName) from Person p")
   List<String> findAllFullNameConcatUpper();

   @Query("select lower(p.name || ' ' || p.lastName) from Person p")
   List<String> findAllFullNameConcatLower();

   @Query("select upper(p.name), lower(p.lastName) from Person p")
   List<Object[]> findAllFullNameConcatMix();

   // ? USO DEL COUNT PARA CONSULTAS QUERY
   @Query("select count(distinct(p.programmingLanguage)) from Person p")
   Long countProgrammingDistinct();

   // ? USO DE DISTINCT PARA LAS CONSULTAS QUERY PERSONALIZADAS
   @Query("select p.name from Person p")
   List<String> finAllNames();

   @Query("select distinct(p.name) from Person p")
   List<String> finAllNamesDistinct();

   @Query("select distinct(p.programmingLanguage) from Person p")
   List<String> finAllProgrammingDistinct();

   // ? CONSTRUCTOR PERSOANLIZADO
   // Para poder hacer esta consulta debemos crear un constructor con los datos de
   // la consulta
   @Query("select new Person(p.name, p.lastName) from Person p")
   List<Person> finAllPersonalicePersonList();

   // ? DTO PERSOANLIZADO
   // Este query hace uso del PersonDto como no esta dentro del contexto de
   // spring @Entity se debe colocar el package del cual viene la clase
   // persoanlizada DTO
   @Query("select new springboot.appjpa.dto.PersonDto(p.name, p.lastName) from Person p")
   List<PersonDto> finAllPersonalicePersonDto();

   @Query("select p.name from Person p where p.id=?1")
   String getNameById(Long id);

   @Query("select concat(p.name, ' ', p.lastName) as fullName from Person p where p.id=?1")
   String getFullNameById(Long id);

   // Consultas persoanlizadas
   @Query("select p from Person p where p.name=?1 and p.programmingLanguage=?2")
   List<Person> findByProgrammingLanguageAndName(String name, String programmingLanguage);

   // consulta personalizada para obtener solo dos atributos del objeto Person
   @Query("select p.name, p.programmingLanguage from Person p")
   List<Object[]> obtenerPersonData();

   @Query("select p, p.programmingLanguage from Person p")
   List<Object[]> findAllMixPerson();

   @Query("select p.id, p.name, p.lastName, p.programmingLanguage from Person p")
   List<Object[]> obtenerPersonDataFullList();

   @Query("select p.id, p.name, p.lastName, p.programmingLanguage from Person p where p.id=?1")
   Object obtenerPersonDataFullObject(Long id);

   @Query("select p from Person p where p.id=?1")
   Optional<Person> findOne(Long id);

   @Query("select p from Person p where p.name=?1")
   Optional<Person> findOneName(String name);

   // buscar la primera coincidencia que encuentre con las primeras letras del
   // nombre %?1%
   @Query("select p from Person p where p.name like %?1%")
   Optional<Person> findOneLikeName(String name);

   Optional<Person> findByNameContaining(String name);
}
