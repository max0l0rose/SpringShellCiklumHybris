package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@SequenceGenerator(name = "sequenceGen", sequenceName = "seqProduct", allocationSize = 1, initialValue = 1)
@Table(
//		name = "Products"
)
public class Product extends BaseEntity
//		implements StringsArray
{

	public final static String[][] headers = {{"Id", "ProdName", "Price", "Status", "Created", "Modified" },};

	@NotNull
	@Column(length = 100, columnDefinition = "varchar(50) default 'Shampoo'") // ;)
	String name;

	int price;

//	@OneToOne
//	public Department department;

	//@Basic(optional = false)

	//@Enumerated
	ProdStatus status;


	public Product(String name, int price, ProdStatus status) {
		this.name = name;
		this.price = price;
		this.status = status;
	}

	@OneToMany(mappedBy = "product",
			//fetch = FetchType.LAZY
			cascade = CascadeType.ALL//, orphanRemoval = true
	)
//	@JoinColumn(
//			name = "product_id"
//	//		, referencedColumnName = "id"
//	)
//	@PrimaryKeyJoinColumn//	@JoinTable(name = "order_items",
//			joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
//			inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")}
//	)
	private Set<OrderItems> orderItems = new HashSet<>();

//	@ManyToMany(//mappedBy = "products"
//	           )
//	@JoinTable(name = "order_items",
//			joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
//			inverseJoinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")}
//	)
//	List<Order> orders;


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
