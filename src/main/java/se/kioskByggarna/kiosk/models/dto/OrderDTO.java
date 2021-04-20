package se.kioskByggarna.kiosk.models.dto;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer customerId;
    private String finalisedByDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFinalisedByDate() {
        return finalisedByDate;
    }

    public void setFinalisedByDate(String finalisedByDate) {
        this.finalisedByDate = finalisedByDate;
    }

    public OrderDTO(Integer id, Integer customerId, String finalisedByDate) {
        this.id = id;
        this.customerId = customerId;
        this.finalisedByDate = finalisedByDate;
    }

    public OrderDTO() {

    }
}
