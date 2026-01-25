package com.faheem.ecommerce;

import com.faheem.ecommerce.order.Order;
import jakarta.persistence.*;
import lombok.*;

public class orderline {
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    @Entity
    public static class OrderLine {
        @Id
        @GeneratedValue
        private Integer id;

        @ManyToOne
        @JoinColumn(name = "order_id")
        private Order order;

        private Integer productid;
        private double quantity;

    }
}
