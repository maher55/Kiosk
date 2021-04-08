package se.kioskByggarna.kiosk.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.kioskByggarna.kiosk.models.Product;
import se.kioskByggarna.kiosk.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
}
