package se.kioskByggarna.kiosk.models.dto;

import se.kioskByggarna.kiosk.models.OrderLineId;
import se.kioskByggarna.kiosk.models.Product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "orderLines")
public class OrderLineDTO {
    @Id
    private OrderLineId id;
    private Integer amount;
    private BigDecimal price;


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

    public OrderLineId getId() {
        return id;
    }

    public void setId(OrderLineId id) {
        this.id = id;
    }

    public OrderLineDTO(OrderLineId orderLineId, Integer amount, BigDecimal price) {
        this.id = id;
        this.amount = amount;
        this.price = price;
    }

    public OrderLineDTO() {
    }
}
