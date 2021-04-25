package se.kioskByggarna.kiosk.dao;

import org.springframework.stereotype.Repository;
import se.kioskByggarna.kiosk.models.dto.OrderLineDTO;
import se.kioskByggarna.kiosk.repository.OrderLineRepository;

import java.util.Optional;

@Repository
public class OrderLineDAO {
    private final OrderLineRepository repository;

    public OrderLineDAO(OrderLineRepository repository) {
        this.repository = repository;
    }


    public OrderLineDTO addOrderLine(OrderLineDTO orderLineDTO) {
        repository.save(orderLineDTO);
        return orderLineDTO;
    }

    public Iterable<OrderLineDTO> getAllOrderLines() {
        return repository.findAll(); }

    public Optional<OrderLineDTO> findOrderLineById(Integer id) {
        return repository.findById(id);
    }

    public Iterable<OrderLineDTO> findOrderLineByOrderId(Integer orderId) {
        return repository.findByOrderId(orderId);
    }

    public void deleteOrderLine(Integer id) {
        repository.deleteById(id);
    }

    public void deleteOrderLinesByOrderId(Integer orderId) {
        repository.deleteByOrderId(orderId);
    }
}
