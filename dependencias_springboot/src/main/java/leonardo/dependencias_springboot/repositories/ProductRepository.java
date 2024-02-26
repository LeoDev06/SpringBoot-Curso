package leonardo.dependencias_springboot.repositories;

import java.util.List;

import leonardo.dependencias_springboot.models.Product;

public interface ProductRepository {
   List<Product> findAll();

   Product findById(Long id);
}
