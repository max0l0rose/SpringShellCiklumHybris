package com.company.repo;

import com.company.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdRepo extends //Repository<User, Long>
									CrudRepository<Product, Long>
{
	List<Product> findByName(String name);

	//User findById(long id);
}


