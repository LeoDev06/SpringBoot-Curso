package leonardo.dependencias_springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardo.dependencias_springboot.models.Product;
import leonardo.dependencias_springboot.services.ProductServices;

@RestController
@RequestMapping("/api")
public class SomeRestController {

   @Autowired //inyecta una dependecia
   private ProductServices services;

   @GetMapping("/")
   public List<Product> List() {
      return services.findAll();
   }

   @GetMapping("/{id}")
   public Product show(@PathVariable Long id) {
      return services.findById(id);
   }
}
