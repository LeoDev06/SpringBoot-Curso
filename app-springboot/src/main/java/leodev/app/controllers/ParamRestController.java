package leodev.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import leodev.app.models.dtos.ParamsDto;

@RestController
@RequestMapping("/api/params")
public class ParamRestController {
   // metodo que recibe un parametro por url
   // ejemplo: http://localhost:8080/api/params/summitMessaje?text=hola
   @GetMapping("/summitMessaje")
   public ParamsDto summitMessaje(@RequestParam(required = false, defaultValue = "not text") String text) {
      ParamsDto messaje = new ParamsDto();
      messaje.setId(3);
      messaje.setMessage(text);
      return messaje;
   }

   // metodo que recibe dos parametros por url
   // ejemplo: http://localhost:8080/api/params/record?id=4&text=hola
   @GetMapping("/record")
   public ParamsDto record(@RequestParam Integer id, @RequestParam String text) {
      ParamsDto recordTask = new ParamsDto();
      recordTask.setId(id);
      recordTask.setMessage(text);

      return recordTask;
   }

   // metodo que recibe dos parametros por url mediante HttpServletRequest
   // ejemplo: http://localhost:8080/api/params/request?id=4&text=hola
   @GetMapping("/request")
   public ParamsDto request(HttpServletRequest request) {
      ParamsDto requestParam = new ParamsDto();
      requestParam.setId(Integer.parseInt(request.getParameter("id")));
      requestParam.setMessage(request.getParameter("text"));

      return requestParam;
   }
}
