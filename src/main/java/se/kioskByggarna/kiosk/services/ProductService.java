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
                ProductType.FRUIT, "9.99", "SEK",
                "/images/banana.jpg",
                "Try one. It's great!"));
        productList.add(new Product("Potatis",
                ProductType.VEGETABLE, "4.00", "SEK",
                "/images/potatoe.jpg",
                "Try one. It's great!"));
        productList.add(new Product("Croissant",
                ProductType.PANTRY, "12.00", "SEK",
                "/images/croissant.jpg",
                "Try one. It's great!"));
        productList.add(new Product("Camembert",
                ProductType.DAIRY, "79.45", "SEK",
                "/images/camembert.jpg",
                "Try one. It's great!"));
        productList.add(new Product("Lax",
                ProductType.FISH, "65.00", "SEK",
                "/images/salmon.jpg",
                "Try one. It's great!"));
        return productList;
    }
}
