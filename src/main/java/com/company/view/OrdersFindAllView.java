package com.company.view;

import com.company.model.Order1;
import org.springframework.ui.Model;

public interface OrdersFindAllView extends IView
		                                           //, StringsArray
{
	String[][] headers = {{"OrderId", "UserId", "Status", "ProductsCount",
			"ProductsTotalPrice", "ProductsTotalCount", "Created", "Modified" },}; //public final static

	Order1 getOrder();
	int getProdsCount();
	Integer getProdsTotalPrice();
	Integer getProdsTotalQuantity();

	//MoreObjects.firstNonNull(x, -1);
	default String[] toStringsArray() {
		Order1 order = getOrder();
		return new String[] {
				String.valueOf(order.getId()),
				String.valueOf(order.getUser() != null ? order.getUser().getId() : null),
				String.valueOf(order.getStatus()),
				String.valueOf(getProdsCount()),
				String.valueOf(getProdsTotalPrice()),
				String.valueOf(getProdsTotalQuantity()),
				String.valueOf(order.getCreated()), String.valueOf(order.getModified())
		};
	}

	//@Override
	static public String render(Model model) {
		model.addAttribute("headers", headers);
		return IView.render(model);
	}

}
