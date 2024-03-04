package springboot.jpa.eventosprepostpersistencia.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Embeddable
public class Audit {

   @Column(name = "creat-at")
   private LocalDateTime creatAt;

   @Column(name = "update-at")
   private LocalDateTime updateAt;

   // Este metodo se ejecutará cuando se cree un usuario en la DB "auditoria"
   @PrePersist
   public void prePersist() {
      this.creatAt = LocalDateTime.now();
      System.out.println("Evento del ciclo de vida del entity Pre-Persist");
   }

   // Este metodo se ejecutará cuando se actualice un usuario en la DB "auditoria"
   @PreUpdate
   public void preUpdate() {
      this.updateAt = LocalDateTime.now();
      System.out.println("Evento del ciclo de vida del entity Pre-Update");
   }

   public LocalDateTime getCreatAt() {
      return creatAt;
   }

   public void setCreatAt(LocalDateTime creatAt) {
      this.creatAt = creatAt;
   }

   public LocalDateTime getUpdateAt() {
      return updateAt;
   }

   public void setUpdateAt(LocalDateTime updateAt) {
      this.updateAt = updateAt;
   }
}
