package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@SequenceGenerator(name = "sequenceGen", sequenceName = "seqProduct", allocationSize = 1, initialValue = 1)
public class Product extends BaseEntity implements StringsArray {

	public final static String[][] headers = {{"Id", "ProdName", "Department", "Role", "Created", "Modified" },};

	@NotNull
	@Column(length = 100, columnDefinition = "varchar(50) default 'Shampoo'") // ;)
	@Order(2)
	String name;

	@Order(3)
	int price;

//	@OneToOne
//	public Department department;

	//@Basic(optional = false)

	//@Enumerated
	ProdStatus status;


	public String[] toStringsArray() {
		return new String[] {
				String.valueOf(id), String.valueOf(name), String.valueOf(price),
				String.valueOf(status), String.valueOf(created), String.valueOf(modified)
		};
	}

//	public static String[] getHeaders() {
//		return new String[] {String.valueOf(id), String.valueOf(username), String.valueOf(department), String.valueOf(created), String.valueOf(modified)};
//	}

	@Override
	public String toString() {
		return "Product{" +
				       "name='" + name + '\'' +
				       ", price=" + price +
				       ", status=" + status +
				       '}';
	}
}
