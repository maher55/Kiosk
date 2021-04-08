package se.kioskByggarna.kiosk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Product {

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(    @JsonProperty("name") String name,
                       @JsonProperty("type") ProductType type,
                       @JsonProperty("double") Double price,
                       @JsonProperty("img") String img,
                       @JsonProperty("description") String description) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.img = img;
        this.description = description;
    }

    private String name;
    private ProductType type;
    private Double price;
    private String img;
    private String description;

}
