package com.springboot.factura_bill.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
public class Invoice {

   @Autowired
   private Customer customer;

   @Value("${invoice.description}")
   private String description;

   @Autowired
   @Qualifier("invoice")
   private List<Item> items;

   @PostConstruct
   public void init() {
      System.out.println("Creando el componenete de la factura");
      description = description.concat("del cliente: ").concat(customer.getName()).concat(" ")
            .concat(customer.getLastName());
   }

   @PreDestroy
   public void destroy() {
      System.out.println("destruyendo el componente o @Bean invoice");
   }

   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public List<Item> getItems() {
      return items;
   }

   public void setItems(List<Item> items) {
      this.items = items;
   }

   public int getTotalBill() {
      /*
       * ? Forma tradicional
       * int total = 0;
       * for (Item item : items) {
       * total += item.getSubTotal();
       * }
       * return total;
       */
      return items.stream()
            .map(item -> item.getSubTotal())
            .reduce(0, (sum, subTotal) -> sum + subTotal);

   }
}
