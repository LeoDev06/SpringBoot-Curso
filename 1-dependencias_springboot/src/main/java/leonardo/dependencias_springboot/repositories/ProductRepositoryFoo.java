package leonardo.dependencias_springboot.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import leonardo.dependencias_springboot.models.Product;

/* si queremos un nombre personalizado simplemente declaramos de forma
explicita el nombre con el cual accederemos a la clase mediante el 
 estereotipo repository teniemdo en cuenta que la inicial debe ser en minuscula
al no declarar explicitamente el estereotipo por defecto quedara como
ProductRepositoryFoo */

@Repository("productFoo") 
public class ProductRepositoryFoo implements ProductRepository {

   @Override
   public List<Product> findAll() {
      return Collections.singletonList(
            new Product(1l, "Monitor Asus 27pds", 600l));
   }

   @Override
   public Product findById(Long id) {
      return new Product(id, "Monitor Asus 27pds", 600l);
   }

}
   