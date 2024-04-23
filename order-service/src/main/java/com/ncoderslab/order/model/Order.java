package com.ncoderslab.order.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "t_orders")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_number")
    private String orderNumber;
    @Column(name = "sku_code")
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
