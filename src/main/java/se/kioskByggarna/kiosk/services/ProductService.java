package se.kioskByggarna.kiosk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kioskByggarna.kiosk.dao.ProductDAO;
import se.kioskByggarna.kiosk.models.Product;
import se.kioskByggarna.kiosk.models.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
/*
    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Banan",
                ProductType.FRUIT, "9.99", "SEK",
                "/images/banana.jpg",
                "Try one. It's great!"));
        productList.add(new Product(2, "Potatis",
                ProductType.VEGETABLE, "4.00", "SEK",
                "/images/potatoe.jpg",
                "Try one. It's great!"));
        productList.add(new Product(3, "Croissant",
                ProductType.PANTRY, "12.00", "SEK",
                "/images/croissant.jpg",
                "Try one. It's great!"));
        productList.add(new Product(4, "Camembert",
                ProductType.DAIRY, "79.45", "SEK",
                "/images/camembert.jpg",
                "Try one. It's great!"));
        productList.add(new Product(5, "Lax",
                ProductType.FISH, "65.00", "SEK",
                "/images/salmon.jpg",
                "Try one. It's great!"));
        return productList;
    }
*/
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        for (ProductDTO productDTO : productDAO.getAllProducts()) {
            products.add(mapToProduct(productDTO));
        }
        return products;
    }

    public void addProduct(Product product) {
        productDAO.addProduct(mapFromProduct(product));
    }

    public Product getProductById(Integer id) {
        if(productDAO.findProductByID(id).isPresent()){
            return mapToProduct(productDAO.findProductByID(id).get());
        }
        return null;
    }

    public void deleteProduct(Integer id) {
        productDAO.deleteProduct(id);
    }

    private Product mapToProduct(ProductDTO productDTO) {
        return new Product(productDTO.getId(),
                productDTO.getName(),
                productDTO.getType(),
                productDTO.getPrice(),
                productDTO.getCurrency(),
                productDTO.getImg(),
                productDTO.getDescription());
    }

    private ProductDTO mapFromProduct(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getType(),
                product.getPrice(),
                product.getCurrency(),
                product.getImg(),
                product.getDescription());
    }
}



