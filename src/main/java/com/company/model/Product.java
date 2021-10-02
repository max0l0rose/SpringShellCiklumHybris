package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@SequenceGenerator(name = "sequenceGen", sequenceName = "seqProduct", allocationSize = 1, initialValue = 1)
@Table(name = "Products")
public class Product extends BaseEntity implements StringsArray {

	public final static String[][] headers = {{"Id", "ProdName", "Department", "Role", "Created", "Modified" },};

	@NotNull
	@Column(length = 100, columnDefinition = "varchar(50) default 'Shampoo'") // ;)
	String name;

	int price;

//	@OneToOne
//	public Department department;

	//@Basic(optional = false)

	//@Enumerated
	ProdStatus status;


	@ManyToMany(//mappedBy = "products"
	           )
	@JoinTable(name = "order_items",
			joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")}
	)
	List<Order> orders;


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
