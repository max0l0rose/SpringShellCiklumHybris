package com.company.model;

public interface OrdersViewModel extends StringsArray
{
	String[][] headers = {{"Id", "UserId", "Status", "ProductsCount", "ProductsTotalPrice", "Created", "Modified" },}; //public final static

	Order1 getOrder();
	int getProdsCount();
	int getProdsTotalPrice();

	default String[] toStringsArray() {
		Order1 order = getOrder();
		return new String[] {
				String.valueOf(order.getId()), String.valueOf(order.getUserId()),
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
