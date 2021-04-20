package se.kioskByggarna.kiosk.models;

import java.io.Serializable;
import java.util.Objects;

public class OrderLineId implements Serializable {

        private Integer orderId;
        private Integer productId;

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public OrderLineId() {
        }

        public OrderLineId(Integer orderId, Integer productId) {
            this.orderId = orderId;
            this.productId = productId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            OrderLineId accountId = (OrderLineId) o;
            return orderId.equals(accountId.orderId) &&
                    productId.equals(accountId.productId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(orderId, productId);
        }
    }

