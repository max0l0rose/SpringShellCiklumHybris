package com.company.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

//@TableGenerator(name="DepTableGen",
//		table = "sequences",
//		pkColumnName="SEQ_NAME", // Specify the name of the column of the primary key
//		valueColumnName="SEQ_NUMBER", // Specify the name of the column that stores the last value generated
//		pkColumnValue="LICENSE_ID" // Specify the primary key column value that would be considered as a primary key generator
////		,allocationSize=1
//)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
//@SequenceGenerator(name = "sequenceGen", sequenceName = "seqDepart", allocationSize = 1)
@Table(
//		name = "order_items"
)
@IdClass(OrderProductPK.class)
public class OrderItems
		//implements Serializable
		//extends BaseEntity
{
	//public final static String[][] headers = {{"Id", "user_id", "Status", "Created", "Modified" },};

//	@Column(name = "product_id"
////			, insertable = false, updatable = false
//	)
	private long productId;

//	@Column(name = "order_id"
////			, insertable = false, updatable = false
//	)
	@Id
	private long orderId;


//	public OrderItems(Product product, Order1 order, int quantity) {
//		this.product = product;
//		this.order = order;
//		this.quantity = quantity;
//	}


//	//@Access(AccessType.PROPERTY)
//	@ManyToOne
//	//@JoinColumn(name = "product", referencedColumnName = "id", nullable = false)
//	@Id
//	private Product product;
//
////	public Product getProduct() {
////		return product;
////	}
////
////	public void setProduct(Product product) {
////		this.product = product;
////	}
//
//
//	//@Access(AccessType.PROPERTY)
//	@ManyToOne
//	//@JoinColumn(name = "order1", referencedColumnName = "id", nullable = false)
//	@Id
//	private Order1 order;
//
////	public Order1 getOrder() {
////		return order;
////	}
////
////	public void setOrder(Order1 order) {
////		this.order = order;
////	}



	@Basic
	//@Column(name = "quantity")
	private int quantity;


	//	@ManyToMany(//mappedBy = "orders"
//			//fetch = FetchType.LAZY
//	)
//	@JoinTable(name = "order_items",
//			joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
//			inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")}
//	)
//	private List<Product> products;



//	public String[] toStringsArray() {
//		return new String[] {String.valueOf(id), String.valueOf(order_id), String.valueOf(status),
//				String.valueOf(created), String.valueOf(modified)};
//	}


//	@Override
//	public String toString() {
//		return "Order{"
//				       + id +
//				       ", user_id=" + order_id +
//				       ", status=" + status +
//				       ", created=" + created +
//				       ", modified=" + modified +
//				       '}';
//	}

}


