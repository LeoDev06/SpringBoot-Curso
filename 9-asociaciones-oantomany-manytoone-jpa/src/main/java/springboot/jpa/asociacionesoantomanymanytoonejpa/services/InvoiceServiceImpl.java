package springboot.jpa.asociacionesoantomanymanytoonejpa.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.jpa.asociacionesoantomanymanytoonejpa.entities.Invoice;
import springboot.jpa.asociacionesoantomanymanytoonejpa.handlerException.ErrorMessageException;
import springboot.jpa.asociacionesoantomanymanytoonejpa.repositories.InvoiceRepository;
import springboot.jpa.asociacionesoantomanymanytoonejpa.repositories.UserRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {

   private final InvoiceRepository repository;
   private final UserRepository userRepository;

   public InvoiceServiceImpl(InvoiceRepository repository, UserRepository userRepository) {
      this.repository = repository;
      this.userRepository = userRepository;
   }

   @Override
   @Transactional
   public Invoice save(Invoice invoice) {
      Long idUser = invoice.getUser().getId();
      System.out.println("ID_USER: _______ " + idUser + " _______");
      if (invoice != null && idUser != null && userRepository.existsById(idUser)) {
         return repository.save(invoice);
      } else {
         throw new ErrorMessageException("No se pudo guardar la factura, datos incorrectos");
      }
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
