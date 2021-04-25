package se.kioskByggarna.kiosk.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.kioskByggarna.kiosk.dao.CustomerDAO;
import se.kioskByggarna.kiosk.models.Customer;
import se.kioskByggarna.kiosk.models.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    public static CustomerDAO customerDAO;
    public CustomerService customerService;
    public List<CustomerDTO> allCustomers;

    @BeforeAll
    public static void initAll() {
        customerDAO = Mockito.mock(CustomerDAO.class);
    }

    @BeforeEach
    public void init() {
        customerService = new CustomerService(customerDAO);
        allCustomers = new ArrayList<>();
        allCustomers.add(new CustomerDTO(1, "Rasputin", "rasputin@gmail.ru", "070927140"));
        allCustomers.add(new CustomerDTO(2, "Baba Vanga", "b_Vanga11@gmail.su", "64226434"));
        allCustomers.add(new CustomerDTO(3, "Zarathustra", "mazdas-nr1@magi", "7543615543"));
    }

    @Test
    void addCustomer_ShouldAddCustomerAndReturnCorrectName() {
        CustomerDTO customerDTOFromDatabase = new CustomerDTO(1, "Rasputin", "rasputin@gmail.ru", "070927140");
        Customer newCustomer = new Customer(null, "Rasputin", "rasputin@gmail.ru", "070927140");
        Mockito.when(customerDAO.addCustomer(ArgumentMatchers.any(CustomerDTO.class))).thenReturn(customerDTOFromDatabase);
        Customer createdCustomer = customerService.addCustomer(newCustomer);
        Assertions.assertThat(newCustomer.getName()).isEqualTo(createdCustomer.getName());
    }

    @Test
    void getCustomerById_ShouldFindCustomerById() {
        CustomerDTO customerDTOFromDatabase = new CustomerDTO(1, "Rasputin", "rasputin@gmail.ru", "070927140");
        Customer expectedCustomer = new Customer(1, "Rasputin", "rasputin@gmail.ru", "070927140");

        Mockito.when(customerDAO.findCustomerById(1)).thenReturn(Optional.of(customerDTOFromDatabase));
        Customer actualCustomer = customerService.getCustomerById(1);

        Assertions.assertThat(actualCustomer.getId()).isEqualTo(expectedCustomer.getId());
    }

    @Test
    void getAllCustomers_ShouldReturnAllCustomers() {
        List<Customer> expectedCustomers = new ArrayList<>();
        expectedCustomers.add(new Customer(1, "Rasputin", "rasputin@gmail.ru", "070927140"));
        expectedCustomers.add(new Customer(2, "Baba Vanga", "b_Vanga11@gmail.su", "64226434"));
        expectedCustomers.add(new Customer(3, "Zarathustra", "mazdas-nr1@magi", "7543615543"));
        Mockito.when(customerDAO.getAllCustomers()).thenReturn(allCustomers);
        List<Customer> actualCustomers = customerService.getAllCustomers();
        Assertions.assertThat(actualCustomers.size()).isEqualTo(expectedCustomers.size());
    }
    @Test
    void getCustomerById_ShouldFindCustomerWithCorrectName() {
        CustomerDTO customerDTOFromDatabase = new CustomerDTO(1, "Rasputin", "rasputin@gmail.ru", "070927140");
        Customer expectedCustomer = new Customer(1, "Rasputin", "rasputin@gmail.ru", "070927140");

        Mockito.when(customerDAO.findCustomerById(1)).thenReturn(Optional.of(customerDTOFromDatabase));
        Customer actualCustomer = customerService.getCustomerById(1);

        Assertions.assertThat(actualCustomer.getName()).isEqualTo(expectedCustomer.getName());
    }

    @Test
    void deleteCustomer_ShouldInvokeDeleteCustomer() {
        customerService.deleteCustomer(1);
        Mockito.verify(customerDAO,Mockito.times(1)).deleteCustomer(1);
    }
    @Test
    void deleteCustomer_ShouldNotInvokeAddCustomer() {
        customerService.deleteCustomer(1);
        Mockito.verify(customerDAO, Mockito.times(0)).addCustomer(new CustomerDTO(null, null, null,null));
    }
    @Test
    void updateCustomer() {
        Customer newCustomer = new Customer(1, "Rasputin", "rasputin@gmail.ru", "070927140");
        CustomerDTO customerDTOFromDatabaseFirstIteration = new CustomerDTO(1, "Григорий", "rasputin@gmail.ru", "070927140");
        CustomerDTO customerDTOFromDatabaseSecondIteration = new CustomerDTO(1, "Rasputin", "rasputin@gmail.ru", "070927140");

        Mockito.when(customerDAO.findCustomerById(1)).thenReturn(Optional.of(customerDTOFromDatabaseFirstIteration));
        Mockito.when(customerDAO.addCustomer(ArgumentMatchers.any(CustomerDTO.class))).thenReturn(customerDTOFromDatabaseSecondIteration);
        Customer actualCustomer = customerService.updateCustomer(newCustomer, 1);

        Assertions.assertThat(actualCustomer.getName()).isEqualTo(newCustomer.getName());
    }
}