package com.company.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GeneralSequenceNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//	@Column(
//			//name = "userid",
//			columnDefinition = "bigint default 2"
//			,updatable = false, insertable = false
//	)
	private Long id;
}