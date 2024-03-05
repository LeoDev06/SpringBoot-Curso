package springboot.crud.apirestfull.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import springboot.crud.apirestfull.validation.IsRequired;

@Entity
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   // @NotBlank: valida que no este vacion "", que no sea un espacio " "
   // y que no sea null
   @NotBlank 
   private String name;

   // notacion para validación personalizada desde el package validation
   @IsRequired 
   private String last_name;

   public User() {
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getLast_name() {
      return last_name;
   }

   public void setLast_name(String last_name) {
      this.last_name = last_name;
   }
}
