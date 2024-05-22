package com.ncoderslab.order.service;

import com.ncoderslab.order.client.InventoryClient;
import com.ncoderslab.order.dto.OrderRequest;
import com.ncoderslab.order.model.Order;
import com.ncoderslab.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;


    public Order placeOrder(OrderRequest orderRequest) {
        boolean isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (isProductInStock) {
            Order order = Order.builder()
                    .orderNumber(UUID.randomUUID().toString())
                    .price(orderRequest.price())
                    .skuCode(orderRequest.skuCode())
                    .quantity(orderRequest.quantity())
                    .build();
            log.info("Order placed with order number {}", order.getOrderNumber());
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Quantity " + orderRequest.quantity() + " of Product with skuCode " + orderRequest.skuCode() + " is not in stock");
        }
    }
}
