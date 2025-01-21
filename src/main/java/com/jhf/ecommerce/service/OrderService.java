// OrderService.java
package com.jhf.ecommerce.service;

import com.jhf.ecommerce.model.Order;
import com.jhf.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrdersByCustomerId(Integer customerId) {
        return orderRepository.findOrdersWithProductVariantsByCustomerId(customerId);
    }
}
