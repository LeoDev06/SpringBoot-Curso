package com.springboot.factura_bill;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.springboot.factura_bill.models.Item;
import com.springboot.factura_bill.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class appConfig {

   @Bean
   @Qualifier("invoice")
   List<Item> itemsInvoice() {

      Product product1 = new Product("Camara Sony", 3000);
      Product product2 = new Product("portatil Asus", 5000);

      List<Item> items = Arrays.asList(
            new Item(product1, 2),
            new Item(product2, 4));

      return items;
   }

   @Bean
   @Qualifier("invoiceOffice")
   List<Item> itemsInvoiceOffice() {

      Product product1 = new Product("Escritorio", 3000);
      Product product2 = new Product("Silla con rodachines", 5000);
      Product product3 = new Product("Pc de escritorio", 9000);
      Product product4 = new Product("monitor LG", 6000);

      List<Item> items = Arrays.asList(
            new Item(product1, 2),
            new Item(product2, 4),
            new Item(product3, 2),
            new Item(product4, 4));

      return items;
   }
}
