package se.kioskByggarna.kiosk.dao;

import org.springframework.stereotype.Repository;
import se.kioskByggarna.kiosk.models.dto.CustomerDTO;
import se.kioskByggarna.kiosk.repository.CustomerRepository;

import java.util.Optional;

@Repository
public class CustomerDAO {
    private final CustomerRepository repository;

    public CustomerDAO(CustomerRepository repository){
        this.repository = repository;
    }


    public CustomerDTO addCustomer(CustomerDTO customerDTO){
        repository.save(customerDTO);
        return customerDTO;
    }
    public Iterable<CustomerDTO>getAllCustomers(){
        return repository.findAll();
    }
    public Optional<CustomerDTO> findCustomerById(Integer id) {
        return repository.findById(id);
    }

    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }
}
