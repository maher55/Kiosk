package se.kioskByggarna.kiosk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kioskByggarna.kiosk.dao.OrderLineDAO;
import se.kioskByggarna.kiosk.models.OrderLine;
import se.kioskByggarna.kiosk.models.dto.OrderLineDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderLineService {
    private final OrderLineDAO orderLineDAO;

    @Autowired
    public OrderLineService(OrderLineDAO orderLineDAO) {
        this.orderLineDAO = orderLineDAO;
    }

    public void addOrderLine(OrderLine orderLine) {
        orderLineDAO.addOrderLine(mapFromOrderLine(orderLine));
    }

    public OrderLine getOrderLineById(Integer id) {
        if (orderLineDAO.findOrderLineById(id).isPresent()) {
            return mapToOrderLine(orderLineDAO.findOrderLineById(id).get());
        }
        return null;
    }

    public List<OrderLine> getAllOrderLines() {
        List<OrderLine> orderLines = new ArrayList<>();
        for (OrderLineDTO orderLineDTO : orderLineDAO.getAllOrderLines()) {
            orderLines.add(mapToOrderLine(orderLineDTO));
        }
        return orderLines;
    }

    public void deleteOrderLine(Integer id) {
        orderLineDAO.deleteOrderLine(id);
    }
    public void deleteOrderLinesByOrderId(Integer orderId) {
        orderLineDAO.deleteOrderLinesByOrderId(orderId);
    }
    private OrderLine mapToOrderLine(OrderLineDTO orderLineDTO) {
        return new OrderLine(
                orderLineDTO.getId(),
                orderLineDTO.getOrderId(),
                orderLineDTO.getProductId(),
                orderLineDTO.getAmount(),
                orderLineDTO.getPrice());
    }

    private OrderLineDTO mapFromOrderLine(OrderLine orderLine) {
        return new OrderLineDTO(
                orderLine.getId(),
                orderLine.getOrderId(),
                orderLine.getProductId(),
                orderLine.getAmount(),
                orderLine.getPrice());
    }

    public OrderLine updateOrderLine(OrderLine newOrderLine, Integer id) {
        OrderLine orderLineToUpdate = getOrderLineById(id);
        if (orderLineToUpdate != null) {
            orderLineToUpdate.setId((newOrderLine.getId()));
            orderLineToUpdate.setOrderId(newOrderLine.getOrderId());
            orderLineToUpdate.setProductId(newOrderLine.getProductId());
            orderLineToUpdate.setAmount(newOrderLine.getProductId());
            orderLineToUpdate.setPrice(newOrderLine.getPrice());
        } else {
            orderLineToUpdate.setId(id);
        }
        OrderLineDTO updatedOrderLine = orderLineDAO.addOrderLine((mapFromOrderLine(orderLineToUpdate)));
        return mapToOrderLine(updatedOrderLine);
    }

    public List<OrderLine> getOrderLinesByOrderId(Integer orderId) {
        List<OrderLine> orderLines = new ArrayList<>();
        for (OrderLineDTO orderLine : orderLineDAO.findOrderLineByOrderId(orderId)) {
            orderLines.add(mapToOrderLine(orderLine));
        }
        return orderLines;
    }


}
