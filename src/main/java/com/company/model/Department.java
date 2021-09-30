package com.company.model;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.SequenceGenerator;
//import javax.validation.constraints.NotNull;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
////@Getter
////@Setter
//@SequenceGenerator(name = "sequenceGen", sequenceName = "seqDepart", allocationSize = 1)
////@TableGenerator(name="DepTableGen",
////		table = "sequences",
////		pkColumnName="SEQ_NAME", // Specify the name of the column of the primary key
////		valueColumnName="SEQ_NUMBER", // Specify the name of the column that stores the last value generated
////		pkColumnValue="LICENSE_ID" // Specify the primary key column value that would be considered as a primary key generator
//////		,allocationSize=1
////)
//public class Department extends com.example.springconsoleappdi.model.BaseEntity
//{
//	public final static String[][] headers = {{"Id", "DepName", "Created", "Modified" },};
//
//	@Column(length = 50)
//	@NotNull
//	private String depName;
//
//
//	public String[] toStringsArray() {
//		return new String[] {String.valueOf(id), depName, String.valueOf(created), String.valueOf(modified)};
//	}
//
//
//	@Override
//	public String toString() {
//		return depName + "{"
//				       + id +
//				       ", modified=" + modified +
//				       '}';
//	}
//
//}
//
//
