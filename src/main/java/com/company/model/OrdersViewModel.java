package com.company.model;

public interface OrdersViewModel extends StringsArray
{
	String[][] headers = {{"Id", "UserId", "Status", "ProductsCount", "ProductsTotalPrice", "Created", "Modified" },}; //public final static

	Order getOrder();
	int getProdsCount();
	int getProdsTotalPrice();

	default String[] toStringsArray() {
		Order order = getOrder();
		return new String[] {
				String.valueOf(order.getId()), String.valueOf(order.getUser_id()),
				String.valueOf(order.getStatus()),
				String.valueOf(getProdsCount()),
				String.valueOf(getProdsTotalPrice()),
				String.valueOf(order.getCreated()), String.valueOf(order.getModified())
		};
	}
}


//interface NamesOnly {
//
//	@Value("#{target.firstname + ' ' + target.lastname}")
//	String getFullName();
//  …
//}
