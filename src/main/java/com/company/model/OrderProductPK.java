package com.company.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

//@Getter
//@Setter
public class OrderProductPK implements Serializable {
//	@Access(AccessType.FIELD)
	@Column(name = "order_id"
			//		, insertable = false, updatable = false
	)
	@Id
	private long orderId;

//	public Order1 getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order1 orderId) {
//		this.order = orderId;
//	}


	@Column(name = "product_id"
			//		, insertable = false, updatable = false
	)
	@Id
	private long productId;

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product productId) {
//		this.product = productId;
//	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OrderProductPK that = (OrderProductPK) o;
		return productId == that.productId && orderId == that.orderId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, orderId);
	}
}
