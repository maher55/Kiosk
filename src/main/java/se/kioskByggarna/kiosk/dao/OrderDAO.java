package se.kioskByggarna.kiosk.dao;

import org.springframework.stereotype.Repository;
import se.kioskByggarna.kiosk.models.dto.OrderDTO;
import se.kioskByggarna.kiosk.repository.OrderRepository;

import java.util.Optional;

@Repository
public class OrderDAO {
    private final OrderRepository repository;

    public OrderDAO(OrderRepository repository){
        this.repository = repository;
    }


    public OrderDTO addOrder(OrderDTO orderDTO){
        repository.save(orderDTO);
        return orderDTO;
    }
    public Iterable<OrderDTO>getAllOrders(){
        return repository.findAll();
    }
    public Optional<OrderDTO> findOrderById(Integer id) {
        return repository.findById(id);
    }

    public void deleteOrder(Integer id) {
        repository.deleteById(id);
    }
}
