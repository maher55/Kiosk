package se.kioskByggarna.kiosk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Product {

    public String getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }

    public ProductType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public Integer getId() {
        return id;
    }
    public Product(@JsonProperty("id") Integer id,
                   @JsonProperty("name") String name,
                   @JsonProperty("type") ProductType type,
                   @JsonProperty("price") String price,
                   @JsonProperty("currency") String currency,
                   @JsonProperty("img") String img,
                   @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.currency = currency;
        this.img = img;
        this.description = description;
    }


    private Integer id;
    private String name;
    private ProductType type;
    private String price;
    private String currency;
    private String img;
    private String description;

}
