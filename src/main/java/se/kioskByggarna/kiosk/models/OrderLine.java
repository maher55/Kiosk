package se.kioskByggarna.kiosk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderLine {

    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Integer amount;
    private String price;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderLine(@JsonProperty("id") Integer id,
                     @JsonProperty("orderId") Integer orderId,
                     @JsonProperty("productId") Integer productId,
                     @JsonProperty("amount") Integer amount,
                     @JsonProperty("price") String price) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
        this.price = price;
    }
}
