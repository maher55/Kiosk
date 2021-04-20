package se.kioskByggarna.kiosk.repository;

import org.springframework.data.repository.CrudRepository;
import se.kioskByggarna.kiosk.models.dto.OrderDTO;

public interface OrderRepository extends CrudRepository<OrderDTO,Integer> {
}
