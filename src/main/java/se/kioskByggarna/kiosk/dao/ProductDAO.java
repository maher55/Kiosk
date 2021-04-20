package se.kioskByggarna.kiosk.dao;

import org.springframework.stereotype.Repository;
import se.kioskByggarna.kiosk.models.dto.ProductDTO;
import se.kioskByggarna.kiosk.repository.ProductRepository;

import java.util.Optional;

@Repository
public class ProductDAO {
    private final ProductRepository repository;

    public ProductDAO(ProductRepository repository){
        this.repository = repository;
    }


    public ProductDTO addProduct(ProductDTO productDTO){
    repository.save(productDTO);
    return productDTO;
    }
    public Iterable<ProductDTO>getAllProducts(){
        return repository.findAll();
    }
    public Optional<ProductDTO> findProductByID(Integer id) {
        return repository.findById(id);
    }

    public void deleteProduct(Integer id) {
        repository.deleteById(id);
    }
}
