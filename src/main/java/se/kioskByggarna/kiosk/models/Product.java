package se.kioskByggarna.kiosk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Product {

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public Product(    @JsonProperty("name") String name,
                       @JsonProperty("type") ProductType type,
                       @JsonProperty("price") String price,
                       @JsonProperty("currency") String currency,
                       @JsonProperty("img") String img,
                       @JsonProperty("description") String description) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.currency = currency;
        this.img = img;
        this.description = description;
    }

    private String name;
    private ProductType type;
    private String price;
    private String currency;
    private String img;
    private String description;

}
