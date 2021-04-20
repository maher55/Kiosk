package se.kioskByggarna.kiosk.repository;

import org.springframework.data.repository.CrudRepository;
import se.kioskByggarna.kiosk.models.OrderLineId;
import se.kioskByggarna.kiosk.models.dto.OrderLineDTO;

public interface OrderLineRepository extends CrudRepository<OrderLineDTO, OrderLineId> {
}
