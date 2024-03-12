package springboot.jpa.asociacionesoantomanymanytoonejpa.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import springboot.jpa.asociacionesoantomanymanytoonejpa.validation.IsRequired;

@Entity
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @IsRequired
   private String name;

   @IsRequired
   @Column(name = "last_name")
   private String lastName;

   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Rol> rols;

   public User() {
      rols = new ArrayList<>();
   }

   public User(String name, String lastName) {
      this();
      this.name = name;
      this.lastName = lastName;
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

   public List<Rol> getRols() {
      return rols;
   }

   public void setRols(List<Rol> rols) {
      this.rols = rols;
   }

   @Override
   public String toString() {
      return "{id=" + id + ", name=" + name + ", lastName=" + lastName + "}";
   }

}
