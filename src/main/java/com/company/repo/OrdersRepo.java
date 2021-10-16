package com.company.repo;

import com.company.model.Order1;
import com.company.view.OrdersFindAllView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//import org.springframework.data.repository.PagingAndSortingRepository;


//@Lazy
public interface OrdersRepo extends
					JpaRepository<Order1, Long>
					//PagingAndSortingRepository<Order, Long>
{
	//List<OrdersView> findById(String uname);
	//Department findById(long id);

	@Query("select o as order, size(o.orderItems) as prodsCount, SUM (p.price) as prodsTotalPrice " +
			       "from Order1 o " +
			       "left join o.orderItems oi " +
			       "left join oi.product p " +
			       "group by o.id")
	List<OrdersFindAllView> getAllOrdersView();
}


