package com.jhf.ecommerce.order;

import com.jhf.ecommerce.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o JOIN FETCH o.orderproductvariants opv WHERE o.customer.id = :customerId")
    List<Order> findOrdersWithProductVariantsByCustomerId(@Param("customerId") Integer customerId);
}
