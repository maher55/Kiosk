package se.kioskByggarna.kiosk.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.kioskByggarna.kiosk.models.Order;
import se.kioskByggarna.kiosk.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

        @Autowired
        OrderService orderService;

        @GetMapping
        public List<Order> getOrders() {
            return orderService.getAllOrders();
        }

        @GetMapping("/{id}")
        public Order getOrderById(@PathVariable("id") Integer id) {
            return orderService.getOrderById(id);
        }

        @PostMapping
        public void addOrder(@RequestBody Order order) {
            orderService.addOrder(order);
        }

        @DeleteMapping("/{id}")
        public void deleteOrder(@PathVariable("id") Integer id) {
            orderService.deleteOrder(id);
        }

        @PostMapping("/{id}")
        public Order updateOrder(@PathVariable("id") Integer id,
                                     @RequestBody Order newOrder) {
            return orderService.updateOrder(newOrder, id);
    }
}
