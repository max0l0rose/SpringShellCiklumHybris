package com.company.repo;

import com.company.model.Product;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//@Lazy
public interface ProdRepo extends //Repository<User, Long>
									CrudRepository<Product, Long>
{
	List<Product> findByName(String name);

	List<Product> findByOrdersId(long orderId);

	//User findById(long id);

//	@Query("select u from #{#entityName} u where u.lastname = ?1")
//	List<User> findByLastname(String lastname);


//	@Query(value = "SELECT * FROM USERS WHERE LASTNAME = ?1",
//			countQuery = "SELECT count(*) FROM USERS WHERE LASTNAME = ?1",
//			nativeQuery = true)
//	Page<User> findByLastname(String lastname, Pageable pageable);


//	@Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
//	User findByLastnameOrFirstname(@Param("lastname") String lastname,
//	                               @Param("firstname") String firstname);


//	@Modifying
//	@Query("update User u set u.firstname = ?1 where u.lastname = ?2")
//	int setFixedFirstnameFor(String firstname, String lastname);
}


//@MappedSuperclass
//public abstract class AbstractMappedType {
//  …
//	String attribute
//}
//
//@Entity
//public class ConcreteType extends AbstractMappedType { … }
//
//@NoRepositoryBean
//public interface MappedTypeRepository<T extends AbstractMappedType>
//		extends Repository<T, Long> {
//
//	@Query("select t from #{#entityName} t where t.attribute = ?1")
//	List<T> findAllByAttribute(String attribute);
//}
//
//public interface ConcreteRepository
//		extends MappedTypeRepository<ConcreteType> { … }
//

