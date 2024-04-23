package com.ncoderslab.order.service;

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


    public Order placeOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .price(orderRequest.price())
                .skuCode(orderRequest.skuCode())
                .quantity(orderRequest.quantity())
                .build();
        log.info("Order placed with order number {}", order.getOrderNumber());
        return orderRepository.save(order);
    }
}
