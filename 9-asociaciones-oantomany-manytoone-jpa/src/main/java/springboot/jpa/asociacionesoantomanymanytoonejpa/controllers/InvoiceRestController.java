package springboot.jpa.asociacionesoantomanymanytoonejpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import springboot.jpa.asociacionesoantomanymanytoonejpa.entities.Invoice;
import springboot.jpa.asociacionesoantomanymanytoonejpa.handlerException.BindingResultException;
import springboot.jpa.asociacionesoantomanymanytoonejpa.handlerException.MessageException;
import springboot.jpa.asociacionesoantomanymanytoonejpa.services.InvoiceService;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceRestController {

   private final InvoiceService service;

   public InvoiceRestController(InvoiceService service) {
      this.service = service;
   }

   @PostMapping("/create")
   public ResponseEntity<?> saveInvoice(@Valid @RequestBody Invoice invoice, BindingResult result) {
      if (result.hasFieldErrors()) {
         return BindingResultException.validation(result);
      }

      Invoice invoiceSave = service.save(invoice);
      return ResponseEntity.status(HttpStatus.OK)
            .body(MessageException.messageSatusOk(invoiceSave, "La factura se guardo correctamente"));
   }
}
