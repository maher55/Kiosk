package se.kioskByggarna.kiosk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.repository.CrudRepository;
import se.kioskByggarna.kiosk.models.dto.ProductDTO;
import java.util.HashSet;
import java.util.Set;

public class Order {
    private Integer id;
    private Integer customerId;
    private String finalisedByDate;
    private Set<OrderLine> orderLines;

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

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Order(@JsonProperty("id") Integer id,
                 @JsonProperty("customerId") Integer customerId,
                 @JsonProperty("finalisedByDate") String finalisedByDate) {
        this(id, customerId, finalisedByDate, new HashSet<OrderLine>());
    }

    public Order(Integer id, Integer customerId, String finalisedByDate, Set<OrderLine> orderLines) {
        this.id = id;
        this.customerId = customerId;
        this.finalisedByDate = finalisedByDate;
        this.orderLines = orderLines;
    }
}
