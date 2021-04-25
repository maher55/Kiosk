package se.kioskByggarna.kiosk.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.kioskByggarna.kiosk.models.OrderLine;
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
    @GetMapping("/orderId/{orderId}")
    public List<OrderLine> getOrderLinesByOrderId(@PathVariable("orderId") Integer orderId){
        return orderLineService.getOrderLinesByOrderId(orderId);
    }
    @GetMapping("/{id}")
    public OrderLine getOrderLineById(@PathVariable("orderId") Integer id) {
        return orderLineService.getOrderLineById(id);
    }

    @PostMapping
    public void addOrderLine(@RequestBody OrderLine orderLine) {
        orderLineService.addOrderLine(orderLine);
    }
    @DeleteMapping("/orderId/{orderId}")
    public void deleteOrderLinesByOrderId(@PathVariable("orderId") Integer orderId){
        orderLineService.deleteOrderLinesByOrderId(orderId);
    }
    @DeleteMapping("/{id}")
    public void deleteOrderLine(@PathVariable("id") Integer id) {
        orderLineService.deleteOrderLine(id);
    }

    @PutMapping("/{id}")
    public OrderLine updateOrderLine(@PathVariable("id") Integer id,
                                     @RequestBody OrderLine newOrderLine) {
        return orderLineService.updateOrderLine(newOrderLine, id);
    }
}