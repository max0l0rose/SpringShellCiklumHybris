package com.company.services;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MyService<T> {
	Iterable<T> getAll();
	Optional<T> show(long id);
	T save(T o);
	void delete(long id);
}
