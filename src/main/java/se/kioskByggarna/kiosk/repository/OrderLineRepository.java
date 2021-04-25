package se.kioskByggarna.kiosk.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import se.kioskByggarna.kiosk.models.dto.OrderLineDTO;

import java.util.List;

public interface OrderLineRepository extends CrudRepository<OrderLineDTO, Integer> {
    List<OrderLineDTO> findByOrderId(Integer orderId);
    @Transactional
    void deleteByOrderId(Integer orderId);
}