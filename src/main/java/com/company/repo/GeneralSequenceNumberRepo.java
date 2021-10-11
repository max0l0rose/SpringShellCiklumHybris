package com.company.repo;

import com.company.model.GeneralSequenceNumber;
import org.springframework.data.jpa.repository.JpaRepository;

//@Transactional(propagation = Propagation.NOT_SUPPORTED)
public interface GeneralSequenceNumberRepo extends JpaRepository<GeneralSequenceNumber, Long> {
//	GeneralSequenceNumber findFirstByOrderByVal();
//
////	@Query (value = "Select min(d.count) from detail d", nativeQuery = true)
////	Integer findMinimum();
}
