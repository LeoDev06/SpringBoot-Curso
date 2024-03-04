package leonardo.dependencias_springboot.services;

import java.util.List;

import leonardo.dependencias_springboot.models.Product;

public interface ProductServices {
   List<Product> findAll();

   Product findById(Long id);
}
