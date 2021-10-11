package com.company.services;

import com.company.model.GeneralSequenceNumber;
import com.company.model.Order1;
import com.company.model.OrdersViewModel;
import com.company.repo.GeneralSequenceNumberRepo;
import com.company.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrdersService implements MyService<Order1>{


	@Autowired
	private OrdersRepo ordersRepo;

	@Autowired
	private GeneralSequenceNumberRepo genSeqNumRepo;

//	{
//		return ordersRepo.findAll();
//	}


	public Iterable<Order1> getAll() {
		return ordersRepo.findAll();
	}


	public Optional<Order1> show(long id) {
		return ordersRepo.findById(id);
	}



//	public Optional<Department> findByName(String name) {
//		return depsRepo.findByDepName(name);
//	}


	public Order1 save(Order1 order) {
		genSeqNumRepo.deleteAll();
		GeneralSequenceNumber number2 = new GeneralSequenceNumber();
		//number2.setVal(number.getVal() + 1);
		genSeqNumRepo.save(number2);

//		//GeneralSequenceNumber number = getNextUserId();
//		List<GeneralSequenceNumber> seqList = genSeqNumRepo.findAll();
//		//GeneralSequenceNumber number = seqList.size()>0 ? (GeneralSequenceNumber)seqList.get(0) : new GeneralSequenceNumber();//findFirstByOrderByVal();
//		GeneralSequenceNumber number = seqList.stream().findFirst().orElseGet(() -> {
//			GeneralSequenceNumber num = new GeneralSequenceNumber();
//			genSeqNumRepo.save(num);
//			return num;
//		});//findFirstByOrderByVal();
		order.setUserId(number2.getUId());
		//boolean contains = entityManager.contains(number);



//		//GeneralSequenceNumber number3 = genSeqNumRepo.findFirstByOrderByVal(); // getNextUserId();
//		//boolean contains2 = entityManager.contains(number);

		return ordersRepo.save(order);
	}



	public void delete(long id) {
		ordersRepo.deleteById(id);
	}


	public List<OrdersViewModel> getView() {
		return null;// ordersRepo.getView();
	}

}
