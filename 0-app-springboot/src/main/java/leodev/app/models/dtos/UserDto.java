package leodev.app.models.dtos;

import leodev.app.models.User;

public class UserDto extends User {

   private String email;
   private String message;

   public UserDto(String name, String lastName, String correo) {
      super(name, lastName);
      this.email = correo;
   }

   public UserDto(String name, String lastName, String email, String message) {
      super(name, lastName);
      this.email = email;
      this.message = message;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String correo) {
      this.email = correo;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

}
