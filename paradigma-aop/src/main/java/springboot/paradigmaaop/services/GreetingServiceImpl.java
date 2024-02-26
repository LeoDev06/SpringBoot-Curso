package springboot.paradigmaaop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

   @Override
   public String sayHellow(String person, String phrase) {
      String greeting = phrase + " " + person;
      System.out.println(greeting);
      return greeting;
   }

   @Override
   public String sayHellowError(String person, String phrase) {
      throw new RuntimeException("Este es un error");
   }

}
