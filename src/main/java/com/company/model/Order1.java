package com.company.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//@Data
//@NoArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "sequenceGen", sequenceName = "seqDepart", allocationSize = 1)
//@TableGenerator(name="DepTableGen",
//		table = "sequences",
//		pkColumnName="SEQ_NAME", // Specify the name of the column of the primary key
//		valueColumnName="SEQ_NUMBER", // Specify the name of the column that stores the last value generated
//		pkColumnValue="LICENSE_ID" // Specify the primary key column value that would be considered as a primary key generator
////		,allocationSize=1
//)
@Table(
//		name = "Orders"
)
public class Order1 extends BaseEntity
{
	public final static String[][] headers = {{"Id", "user_id", "Status", "Created", "Modified" },};

	@OneToOne
	//@GeneratedValue//(strategy = GenerationType.IDENTITY)
	@JoinColumn(referencedColumnName = "id")
	private Order1 user;

	ProdStatus status = ProdStatus.IN_STOCK;


	public Order1() {
		this.user = this;
	}

	public Order1(ProdStatus status) {
		this();
		this.status = status;
	}



	@OneToMany(mappedBy = "order",
			//fetch = FetchType.LAZY
			cascade = CascadeType.ALL//, orphanRemoval = true
	)
//	@JoinColumn(
//			name = "order_id"
//			//, referencedColumnName = "id"
//	)
//	@JoinTable(name = "order_items",
//			joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
//			inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")}
//	)
	private Set<OrderItems> orderItems = new HashSet<>();


//	@ManyToMany(//mappedBy = "orders"
//			//fetch = FetchType.LAZY
//	)
//	@JoinTable(name = "order_items",
//			joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
//			inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")}
//	)
//	private List<Product> products;



	public String[] toStringsArray() {
		return new String[] {String.valueOf(id), String.valueOf(user.getId()), String.valueOf(status),
				String.valueOf(created), String.valueOf(modified)};
	}


	@Override
	public String toString() {
		return "Order{"
				       + id +
				       ", user_id=" + user.getId() +
				       ", status=" + status +
				       ", created=" + created +
				       ", modified=" + modified +
				       '}';
	}



	public void addProduct(Product product, int quantity) {
		orderItems.add(new OrderItems(product, this, quantity));
	}

}


