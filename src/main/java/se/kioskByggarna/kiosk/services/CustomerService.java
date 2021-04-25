package se.kioskByggarna.kiosk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kioskByggarna.kiosk.dao.CustomerDAO;
import se.kioskByggarna.kiosk.models.Customer;
import se.kioskByggarna.kiosk.models.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Customer addCustomer(Customer customer) {
        CustomerDTO newCustomerDTO = customerDAO.addCustomer((mapFromCustomer(customer)));
       return mapToCustomer(newCustomerDTO);

    }

    public Customer getCustomerById(Integer id) {
        if(customerDAO.findCustomerById(id).isPresent()){
            return mapToCustomer(customerDAO.findCustomerById(id).get());
        }
        return null;
    }
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        for (CustomerDTO customerDTO : customerDAO.getAllCustomers()) {
            customers.add(mapToCustomer(customerDTO));
        }
        return customers;
    }
    public void deleteCustomer(Integer id) {
        customerDAO.deleteCustomer(id);
    }

    private Customer mapToCustomer(CustomerDTO customerDTO) {
        return new Customer(customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getEmail(),
                customerDTO.getPhoneNumber());
    }

    private CustomerDTO mapFromCustomer(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhoneNumber());
    }

    public Customer updateCustomer(Customer newCustomer, Integer id) {
        Customer customerToUpdate = getCustomerById(id);
        if(customerToUpdate != null){
            customerToUpdate.setName(newCustomer.getName());
            customerToUpdate.setEmail(newCustomer.getEmail());
            customerToUpdate.setPhoneNumber((newCustomer.getPhoneNumber()));
        }else{
            customerToUpdate.setId(id);
        }
        CustomerDTO updatedCustomer = customerDAO.addCustomer((mapFromCustomer(customerToUpdate)));
        return mapToCustomer(updatedCustomer);
    }
}
