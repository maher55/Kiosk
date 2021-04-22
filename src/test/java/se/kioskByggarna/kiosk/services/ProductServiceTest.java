package se.kioskByggarna.kiosk.services;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.kioskByggarna.kiosk.dao.ProductDAO;
import se.kioskByggarna.kiosk.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    public static ProductDAO productDAO;
    public ProductService productService;
    public List<ProductDAO> allProducts;

    @BeforeAll
    public static void initALL(){
        productDAO = Mockito.mock(ProductDAO.class);

    }

    @BeforeEach
    public void init(){
        productService = new ProductService(productDAO);
        allProducts = new ArrayList<>();
       // allProducts.add(new ProductDAO(id: 1 type: ));

    }
    @Test
    void getAllProducts_ShouldReturnAllProducts () {
      //  Mockito.when(productDAO.getAllProducts()).thenReturn(allProducts);
    }

    @Test
    void addProduct() {
    }

    @Test
    void getProductById() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void updateProduct() {
    }
}