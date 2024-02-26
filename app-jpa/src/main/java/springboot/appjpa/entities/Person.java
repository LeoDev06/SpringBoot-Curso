package springboot.appjpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
   ! CONSTRUCTORES
   Si agregamos un constructor personalizado que resiva los
   atributos, se debe generar obligatoriamente un constructor
   vacio ya que hibernet necesita de un constructor vacio para
   la persistencia de los datos, de lo contrario se puede dejar
   la calse sin constructor personalizado ni vacio ya que por 
   defecto spring crea un constructor vacio por debajo 
*/

@Entity
@Table(name = "persons")
public class Person {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "programming_language")
   private String programmingLanguage;

   public Person() {

   }

   public Person(String name, String lastName) {
      this.name = name;
      this.lastName = lastName;
   }

   public Person(Long id, String name, String lastName, String programmingLanguage) {
      this.id = id;
      this.name = name;
      this.lastName = lastName;
      this.programmingLanguage = programmingLanguage;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getProgrammingLanguage() {
      return programmingLanguage;
   }

   public void setProgrammingLanguage(String programmingLanguage) {
      this.programmingLanguage = programmingLanguage;
   }

   @Override
   public String toString() {
      return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", programmingLanguage="
            + programmingLanguage + "]";
   }

}
