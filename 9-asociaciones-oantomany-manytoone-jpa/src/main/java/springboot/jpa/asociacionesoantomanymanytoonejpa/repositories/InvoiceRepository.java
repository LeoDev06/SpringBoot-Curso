package springboot.jpa.asociacionesoantomanymanytoonejpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springboot.jpa.asociacionesoantomanymanytoonejpa.entities.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
