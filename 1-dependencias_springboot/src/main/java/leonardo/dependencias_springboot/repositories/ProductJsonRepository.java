package leonardo.dependencias_springboot.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import leonardo.dependencias_springboot.models.Product;

public class ProductJsonRepository implements ProductRepository {

   private List<Product> productsList;

   public ProductJsonRepository() {
      /*
       * Crea un objeto que representa un recurso hubicado en la ruta de acceso
       * definida
       */
      ClassPathResource resource = new ClassPathResource("json/product.json");
      /*
       * Es un objeto que se utiliza como herramienta para converitr datos Json en
       * objetos java
       */
      ObjectMapper objectMapper = new ObjectMapper();
      /*
       * Esta línea realiza el proceso de lectura y mapeo:
       * resource.getFile() obtiene el archivo "product.json" como un objeto File.
       * objectMapper.readValue(resource.getFile(), Product[].class) lee el contenido
       * del archivo JSON y lo convierte en una lista de objetos de la clase Product.
       * Arrays.asList(...) convierte la lista resultante en una instancia de List
       * para que pueda ser utilizada como una colección de objetos Product.
       */
      try {
         productsList = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
      } catch (StreamReadException e) {
         e.printStackTrace();
      } catch (DatabindException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public List<Product> findAll() {
      return productsList;
   }

   @Override
   public Product findById(Long id) {
      return productsList.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow();
   }

}
