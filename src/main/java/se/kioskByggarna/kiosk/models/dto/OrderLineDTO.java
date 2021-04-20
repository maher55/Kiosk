package se.kioskByggarna.kiosk.models.dto;

import se.kioskByggarna.kiosk.models.OrderLineId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderLines")
public class OrderLineDTO {
    @Id
    private OrderLineId id;
    private Integer amount;
    private String price;


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

    public OrderLineId getId() {
        return id;
    }

    public void setId(OrderLineId id) {
        this.id = id;
    }

    public OrderLineDTO(OrderLineId orderLineId, Integer amount, String price) {
        this.id = id;
        this.amount = amount;
        this.price = price;
    }

    public OrderLineDTO() {
    }
}
