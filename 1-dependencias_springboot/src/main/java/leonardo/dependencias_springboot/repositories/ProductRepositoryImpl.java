package leonardo.dependencias_springboot.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import leonardo.dependencias_springboot.models.Product;

@RequestScope
@Repository("producList")
public class ProductRepositoryImpl implements ProductRepository {

   List<Product> data;

   public ProductRepositoryImpl() {
      this.data = Arrays.asList(
            new Product(1L, "laptop", 500L),
            new Product(2L, "tablet", 100L),
            new Product(3L, "smartPhone", 350L),
            new Product(4L, "Speakers", 460L));
   }

   @Override
   public List<Product> findAll() {
      return data;
   }

   @Override
   public Product findById(Long id) {
      return data.stream().filter(prod -> prod.getId().equals(id)).findFirst().orElseThrow();
   }
}
