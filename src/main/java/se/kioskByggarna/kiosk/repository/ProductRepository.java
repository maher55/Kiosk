package se.kioskByggarna.kiosk.repository;

import org.springframework.data.repository.CrudRepository;
import se.kioskByggarna.kiosk.models.dto.ProductDTO;

public interface ProductRepository extends CrudRepository<ProductDTO,Integer> {
}
