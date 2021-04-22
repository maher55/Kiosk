package se.kioskByggarna.kiosk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kioskByggarna.kiosk.dao.OrderLineDAO;
import se.kioskByggarna.kiosk.models.OrderLine;
import se.kioskByggarna.kiosk.models.OrderLineId;
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

    public OrderLine getOrderLineById(OrderLineId id) {
        if(orderLineDAO.findOrderLineById(id).isPresent()){
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
    public void deleteOrderLine(OrderLineId id) {
        orderLineDAO.deleteOrderLine(id);
    }

    private OrderLine mapToOrderLine(OrderLineDTO orderLineDTO) {
        return new OrderLine(orderLineDTO.getId().getOrderId(),
                orderLineDTO.getId().getProductId(),
                orderLineDTO.getAmount(),
                orderLineDTO.getPrice());
    }

    private OrderLineDTO mapFromOrderLine(OrderLine orderLine) {
        return new OrderLineDTO(
                orderLine.getOrderId(),
                orderLine.getProductId(),
                /*new OrderLineId(orderLine.getOrderId(),orderLine.getProductId())*/
                orderLine.getAmount(),
                orderLine.getPrice());
    }

    public OrderLine updateOrderLine(OrderLine newOrderLine, OrderLineId id) {
        OrderLine orderLineToUpdate = getOrderLineById(id);
        if(orderLineToUpdate != null){
            orderLineToUpdate.setOrderId(newOrderLine.getOrderId());
            orderLineToUpdate.setProductId(newOrderLine.getProductId());
            orderLineToUpdate.setAmount(newOrderLine.getProductId());
            orderLineToUpdate.setPrice(newOrderLine.getPrice());
        }else{
            orderLineToUpdate.setOrderId(id.getProductId());
            orderLineToUpdate.setProductId(id.getProductId());
        }
        OrderLineDTO updatedOrderLine = orderLineDAO.addOrderLine((mapFromOrderLine(orderLineToUpdate)));
        return mapToOrderLine(updatedOrderLine);
    }
}
