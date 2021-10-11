package com.company.repo;

import com.company.model.OrderItems;
import com.company.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepo extends JpaRepository<OrderItems, Product> {
}

