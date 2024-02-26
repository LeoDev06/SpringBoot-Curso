package leonardo.dependencias_springboot.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import leonardo.dependencias_springboot.models.Product;
import leonardo.dependencias_springboot.repositories.ProductRepository;

@Service
public class ProductServicesImpl implements ProductServices {

   @Autowired
   @Qualifier("primary")
   private ProductRepository repository;

   @Value("${value.tax}")
   private Double valueTax;

   /*
    * Inyeccion de dependencia por el constructor
    * Con la anotacion @Qualifier especificamos cual de las dos clases
    * sera la que se instancie con la implementacion de los metodos de la interfaz
    ** ! EJEMPLO:
    * public ProductServicesImpl(@Qualifier("producList") ProductRepository
    * repository) {
    * this.repository = repository;
    * }
    */

   @Override
   public List<Product> findAll() {
      /*
       * Para cumplir con el principio de la inmutabilidad
       * y evitar modificar la clase original del repositori
       * lo que hacemos es instanciar el objeto Produc dentro
       * del map ya que map devuelve como resultado de la operacion
       * otro objeto de tipo List<Product>.
       * ejemplo:
       * 
       * return repository.findAll().stream().map(prod -> {
       * Double tax = prod.getPrice() * 1.25d;
       * Product newProd = new Product(prod.getId(), prod.getName(), tax.longValue());
       * return newProd;
       * }).collect(Collectors.toList());
       */

      // ? Una mejor opcion seria:
      return repository.findAll().stream().map(prod -> {
         System.out.println(valueTax.getClass().getSimpleName());
         Double tax = prod.getPrice() * valueTax;
         Product newProd = (Product) prod.clone();
         newProd.setPrice(tax.longValue());
         return newProd;
      }).collect(Collectors.toList());

   }

   @Override
   public Product findById(Long id) {
      return repository.findById(id);
   }

}
