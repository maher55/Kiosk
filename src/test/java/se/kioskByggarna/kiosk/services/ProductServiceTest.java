package se.kioskByggarna.kiosk.services;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.kioskByggarna.kiosk.dao.ProductDAO;
import se.kioskByggarna.kiosk.models.Product;
import se.kioskByggarna.kiosk.models.dto.ProductDTO;
import se.kioskByggarna.kiosk.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    public static ProductDAO productDAO;
    public ProductService productService;
    public List<ProductDTO> allProducts;

    @BeforeAll
    public static void initALL(){
        productDAO = Mockito.mock(ProductDAO.class);

    }

    @BeforeEach
    public void init(){
        productService = new ProductService(productDAO);
        allProducts = new ArrayList<>();
        allProducts.add(new ProductDTO(1, "Drink", "5"));
        allProducts.add(new ProductDTO(2, "Pizza", "70"));
        allProducts.add(new ProductDTO(3, "Toy", "150"));
    }
    @Test
    void getAllProducts_ShouldReturnAllProducts () {
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product(1, "Drink", "5"));
        expectedProducts.add(new Product(2, "Pizza", "70"));
        expectedProducts.add(new Product(3, "Toy", "150"));
      Mockito.when(productDAO.getAllProducts()).thenReturn(allProducts);
      List<Product> actualProducts = productService.getAllProducts();

        Assertions.assertThat(actualProducts.size()).isEqualTo(expectedProducts.size());
    }

    @Test
    void addProduct() {
        ProductDTO productDTO = new ProductDTO(1, "Drink", "5");
        Product newProduct = new Product(0, "Drink", "5");
        Mockito.when(productDAO.addProduct(ArgumentMatchers.any(ProductDTO.class))).thenReturn(productDTO);
        //Product createProducts = productService.addProduct(newProduct);
        //Assertions.assertThat(newProduct.getName()).isEqualTo(createProducts.getName());
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