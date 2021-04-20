package se.kioskByggarna.kiosk.dao;

import org.springframework.stereotype.Repository;
import se.kioskByggarna.kiosk.models.OrderLineId;
import se.kioskByggarna.kiosk.models.dto.OrderLineDTO;
import se.kioskByggarna.kiosk.repository.OrderLineRepository;

import java.util.Optional;

@Repository
public class OrderLineDAO {
    private final OrderLineRepository repository;

    public OrderLineDAO(OrderLineRepository repository){
        this.repository = repository;
    }


    public OrderLineDTO addOrderLine(OrderLineDTO orderLineDTO){
        repository.save(orderLineDTO);
        return orderLineDTO;
    }
    public Iterable<OrderLineDTO>getAllOrderLines(){
        return repository.findAll();
    }
    public Optional<OrderLineDTO> findOrderLineById(OrderLineId id) {
        return repository.findById(id);
    }

    public void deleteOrderLine(OrderLineId id) {
        repository.deleteById(id);
    }
}
