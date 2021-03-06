package se.kioskByggarna.kiosk.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.kioskByggarna.kiosk.models.Customer;
import se.kioskByggarna.kiosk.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") Integer id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Integer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer).getId();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") Integer id,
                                   @RequestBody Customer newCustomer) {
        return customerService.updateCustomer(newCustomer, id);
    }
}
