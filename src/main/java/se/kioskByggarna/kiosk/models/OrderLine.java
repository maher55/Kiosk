package se.kioskByggarna.kiosk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

public class OrderLine {

    private Integer orderId;
    private Integer productId;
    private Integer amount;
    private BigDecimal price;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public OrderLine(@JsonProperty("orderId") Integer orderId,
                     @JsonProperty("productId") Integer productId,
                     @JsonProperty("amount") Integer amount,
                     @JsonProperty("price") BigDecimal price) {
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
        this.price = price;
    }
}
