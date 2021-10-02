package com.company.services;

import com.company.model.Order;
import com.company.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrdersService implements MyService<Order>{


	@Autowired
	private OrdersRepo ordersRepo;



	public Iterable<Order> getAll() {
		return ordersRepo.findAll();
	}


	public Optional<Order> show(long id) {
		return ordersRepo.findById(id);
	}



//	public Optional<Department> findByName(String name) {
//		return depsRepo.findByDepName(name);
//	}


	public Order save(Order order) {
		return ordersRepo.save(order);

	}


	public void delete(long id) {
		ordersRepo.deleteById(id);
	}

}
