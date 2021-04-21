package se.kioskByggarna.kiosk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public String getUnit() {
        return unit;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }
    public Product(@JsonProperty("id") Integer id,
                   @JsonProperty("name") String name,
                   @JsonProperty("type") ProductType type,
                   @JsonProperty("price") String price,
                   @JsonProperty("unit") String unit,
                   @JsonProperty("img") String img,
                   @JsonProperty("description") String description,
                   @JsonProperty("inventory") Integer inventory){
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.unit = unit;
        this.img = img;
        this.description = description;
        this.inventory = inventory;
    }
    private Integer id;
    private String name;
    private ProductType type;
    private String price;
    private String unit;
    private String img;
    private String description;
    private Integer inventory;
}
