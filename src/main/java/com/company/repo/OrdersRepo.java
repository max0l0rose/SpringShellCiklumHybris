package com.company.repo;

import com.company.model.Order;
import com.company.model.OrdersViewModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

//@Lazy
public interface OrdersRepo extends
		CrudRepository<Order, Long>
					//PagingAndSortingRepository<Order, Long>
{
	//List<OrdersView> findById(String uname);
	//Department findById(long id);

	//@Query("select o as order, o.products.size as prodsCount, SUM (p.price) as prodsTotalPrice from Order o join o.products p group by o.id")
	//List<OrdersViewModel> getView();
}


