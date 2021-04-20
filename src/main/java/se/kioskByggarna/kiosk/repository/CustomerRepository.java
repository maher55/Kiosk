package se.kioskByggarna.kiosk.repository;

import org.springframework.data.repository.CrudRepository;
import se.kioskByggarna.kiosk.models.dto.CustomerDTO;

public interface CustomerRepository extends CrudRepository<CustomerDTO, Integer> {
}
