package springboot.jpa.asociacionesoantomanymanytoonejpa.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.jpa.asociacionesoantomanymanytoonejpa.entities.Invoice;
import springboot.jpa.asociacionesoantomanymanytoonejpa.generics.CrudGeneric;
import springboot.jpa.asociacionesoantomanymanytoonejpa.repositories.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements CrudGeneric<Invoice, Long> {

   private final InvoiceRepository repository;

   public InvoiceServiceImpl(InvoiceRepository repository) {
      this.repository = repository;
   }

   @Override
   @Transactional
   public Invoice save(Invoice invoice) {
      if(invoice != null){
         return repository.save(invoice);
      }
      return null;
   }

   @Override
   @Transactional
   public Invoice edit(Long id, Invoice invoice) {
      return null;
   }

   @Override
   @Transactional
   public void delete(Long id) {
   }

   @Override
   @Transactional(readOnly = true)
   public Invoice findById(Long id) {
      return null;
   }

   @Override
   @Transactional(readOnly = true)
   public List<Invoice> findAll() {
      return null;
   }
   
}
