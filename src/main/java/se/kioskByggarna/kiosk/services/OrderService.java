package se.kioskByggarna.kiosk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kioskByggarna.kiosk.dao.OrderDAO;
import se.kioskByggarna.kiosk.models.Order;
import se.kioskByggarna.kiosk.models.dto.OrderDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderDAO orderDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Integer addOrder(Order order) {
        return orderDAO.addOrder(mapFromOrder(order)).getId();
    }

    public Order getOrderById(Integer id) {
        if (orderDAO.findOrderById(id).isPresent()) {
            return mapToOrder(orderDAO.findOrderById(id).get());
        }
        return null;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        for (OrderDTO orderDTO : orderDAO.getAllOrders()) {
            orders.add(mapToOrder(orderDTO));
        }
        return orders;
    }

    public void deleteOrder(Integer id) {
        orderDAO.deleteOrder(id);
    }

    private Order mapToOrder(OrderDTO orderDTO) {
        return new Order(orderDTO.getId(),
                orderDTO.getCustomerId(),
                orderDTO.getFinalisedByDate());
    }

    private OrderDTO mapFromOrder(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getCustomerId(),
                order.getFinalisedByDate());
    }

    public Order updateOrder(Order newOrder, Integer id) {
        Order orderToUpdate = getOrderById(id);
        if (orderToUpdate != null) {
            orderToUpdate.setCustomerId(newOrder.getCustomerId());
            orderToUpdate.setFinalisedByDate(newOrder.getFinalisedByDate());
        } else {
            orderToUpdate.setId(id);
        }
        OrderDTO updatedOrder = orderDAO.addOrder((mapFromOrder(orderToUpdate)));
        return mapToOrder(updatedOrder);
    }
}
