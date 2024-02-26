package com.springboot.factura_bill.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
//@JsonIgnoreProperties({"targetSource", "advinsors"}) //soluciona el tema del proxi y variables basura generadas por RequestScope
public class Customer {

   @Value("${customer.name}")
   private String name;

   @Value("${customer.lastName}")
   private String lastName;

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

}
