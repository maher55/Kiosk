package se.kioskByggarna.kiosk.services;

import org.springframework.stereotype.Service;
import se.kioskByggarna.kiosk.models.Product;
import se.kioskByggarna.kiosk.models.ProductType;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public List<Product> getProducts(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Banan",
                ProductType.FRUIT, Double.valueOf("9.99"),
                "/images/banana.jpg",
                "Try one. It's great!"));
        productList.add(new Product("Potatis",
                ProductType.VEGETABLE, Double.valueOf("4.00"),
                "/images/potatoe.jpg",
                "Try one. It's great!"));
        productList.add(new Product("Croissant",
                ProductType.PANTRY, Double.valueOf("12.00"),
                "/images/croissant.jpg",
                "Try one. It's great!"));
        productList.add(new Product("Camembert",
                ProductType.DAIRY, Double.valueOf("79.45"),
                "/images/camembert.jpg",
                "Try one. It's great!"));
        productList.add(new Product("Lax",
                ProductType.FISH, Double.valueOf("65.00"),
                "/images/salmon.jpg",
                "Try one. It's great!"));
        return productList;
    }
}
