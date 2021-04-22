package se.kioskByggarna.kiosk.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.kioskByggarna.kiosk.models.OrderLine;
import se.kioskByggarna.kiosk.models.OrderLineId;
import se.kioskByggarna.kiosk.services.OrderLineService;

import java.util.List;

@RestController
@RequestMapping("/api/orderLines")
public class OrderLineController {
    @Autowired
    OrderLineService orderLineService;

    @GetMapping
    public List<OrderLine> getOrderLines() {
        return orderLineService.getAllOrderLines();
    }

    @GetMapping("/{orderId}_{productId}")
    public OrderLine getOrderLineById(@PathVariable("orderId") Integer orderId, @PathVariable("productId") Integer productId) {
        return orderLineService.getOrderLineById(new OrderLineId(orderId, productId));
    }

    @PostMapping
    public void addOrderLine(@RequestBody OrderLine orderLine) {
        orderLineService.addOrderLine(orderLine);
    }

    @DeleteMapping("/{orderId}_{productId}")
    public void deleteOrderLine(@PathVariable("orderId") Integer orderId, @PathVariable("productId") Integer productId) {
        orderLineService.deleteOrderLine(new OrderLineId(orderId, productId));
    }

    @PutMapping("/{orderId}_{productId}")
    public OrderLine updateOrderLine(@PathVariable("orderId") Integer orderId,
                                     @PathVariable("productId") Integer productId,
                                     @RequestBody OrderLine newOrderLine) {
        return orderLineService.updateOrderLine(newOrderLine, new OrderLineId(orderId, productId));
    }
}