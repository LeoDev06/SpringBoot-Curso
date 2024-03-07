package springboot.jpa.asociacionesoantomanymanytoonejpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Invoice {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "id_user")
   private User user;

   private Double price;
   private Double tax;
   private Integer quantity;

   @Column(name = "total_invoice")
   private Double totalInvoice;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   public Double getTax() {
      return tax;
   }

   public void setTax(Double tax) {
      this.tax = tax;
   }

   public Integer getQuantity() {
      return quantity;
   }

   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }

   public Double getTotalInvoice() {
      return totalInvoice;
   }

   public void setTotalInvoice(Double totalInvoice) {
      this.totalInvoice = totalInvoice;
   }

}
