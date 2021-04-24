package se.kioskByggarna.kiosk.models.dto;

import se.kioskByggarna.kiosk.models.ProductType;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private ProductType type;
    private String price;
    private String unit;
    private String img;
    private String description;

    public ProductDTO(Integer id, String name, ProductType type, String price, String unit, String img, String description, Integer inventory) {
    }

    public Integer getInventory() {
        return inventory;
    }

    private Integer inventory;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductType getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public String getImg() {
        return img;
    }

    public String getDescription() {
        return description;
    }

    public ProductDTO(Integer id, String name, String price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.unit = unit;
        this.img = img;
        this.description = description;
        this.inventory = inventory;
    }

    public ProductDTO() {
    }
}
