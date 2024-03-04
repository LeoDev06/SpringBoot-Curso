package leodev.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* 
   * Estas variables se encuentran definidas en el archivo
   * aplication.properties la idea de este controlador es 
   * enlazar estas variables con las variables de configuracion
   * definidas dentro del archivo nombrado mediante la notacion
   * @Value("${nombre de la variableconfigurada}").
*/

@RestController
@RequestMapping("/api/properties")
public class VariableEnvironmetRestController {

   @Value("${value.id}")
   private Integer id;

   @Value("${value.userName}")
   private String userName;

   @Value("${value.userEmail}")
   private String userEmail;

   @Value("${value.listOfValues}")
   private List<String> listOfValues;

   @Value("#{'${value.listOfValues}'.toUpperCase().split(',')}")
   private List<String> listValues;

   // Manipulacion de objetos mediante (SpEL) Spring Expression Language
   // estricti uso de #{} ya que es un objeto de tipo Map
   @Value("#{${value.valuesMap}}")
   private Map<String, Object> valuesMap;

   @Value("#{${value.valuesMap}.product}")
   private String nameProduct;

   @Autowired
   private Environment environment;

   @GetMapping("/valuesConfig")
   public Map<String, Object> values() {
      Map<String, Object> json = new HashMap<>();
      json.put("id", id);
      json.put("userName", userName);
      json.put("userEmail", userEmail);
      json.put("listOfValues", listOfValues);
      json.put("listValues", listValues);
      json.put("ValuesProduct", valuesMap);
      json.put("nameProduct", nameProduct);

      json.put("idEnvironment", environment.getProperty("value.id"));
      json.put("userNameEnvironment", environment.getProperty("value.userName"));
      json.put("userEmailEnvironment", environment.getProperty("value.userEmail"));
      json.put("listOfValueEnvironment", environment.getProperty("value.listOfValues"));
      json.put("valueProductEnvironment", environment.getProperty("value.valuesMap"));

      return json;
   }

}
