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

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        for (ProductDTO productDTO : productDAO.getAllProducts()) {
            products.add(mapToProduct(productDTO));
        }
        return products;
    }

    public Integer addProduct(Product product) {
        return productDAO.addProduct(mapFromProduct(product)).getId();
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
                productDTO.getUnit(),
                productDTO.getImg(),
                productDTO.getDescription(),
                productDTO.getInventory());
    }

    private ProductDTO mapFromProduct(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getType(),
                product.getPrice(),
                product.getUnit(),
                product.getImg(),
                product.getDescription(),
                product.getInventory());
    }

    public Product updateProduct(Product newProduct, Integer id) {
        Product productToUpdate = getProductById(id);
        if(productToUpdate != null){
            productToUpdate.setName(newProduct.getName());
            productToUpdate.setType(newProduct.getType());
            productToUpdate.setPrice(newProduct.getPrice());
            productToUpdate.setUnit(newProduct.getUnit());
            productToUpdate.setImg((newProduct.getImg()));
            productToUpdate.setDescription(newProduct.getDescription());
            productToUpdate.setInventory((newProduct.getInventory()));
        }else{
            productToUpdate.setId(id);
        }
        ProductDTO updatedProduct = productDAO.addProduct((mapFromProduct(productToUpdate)));
        return mapToProduct(updatedProduct);
    }
}