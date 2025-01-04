// OrderService.java
package com.jhf.ecommerce.order;

import com.jhf.ecommerce.Order;
import com.jhf.ecommerce.order.OrderRepository;
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
