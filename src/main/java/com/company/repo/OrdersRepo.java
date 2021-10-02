package com.company.repo;

import com.company.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface OrdersRepo extends PagingAndSortingRepository<Order, Long> {
	//List<Order> findById(String uname);
	//Department findById(long id);
}