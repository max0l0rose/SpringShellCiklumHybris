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

	@Query("select o as order, o.orderItems.size as prodsCount, SUM (p.price) as prodsTotalPrice \n" +
			       "from Order1 o\n" +
			       "join o.orderItems oi \n" +
			       "join Product p on p.id = oi.productId\n" +
			       "group by o.id")
	List<OrdersFindAllView> getAllOrdersView();
}


