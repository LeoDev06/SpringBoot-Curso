package leonardo.dependencias_springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import leonardo.dependencias_springboot.repositories.ProductJsonRepository;
import leonardo.dependencias_springboot.repositories.ProductRepository;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

   @Bean
   @Qualifier("primary")
   ProductRepository productRepositoryJson() {
      return new ProductJsonRepository();
   }
}
