package com.company.view;

import com.company.model.Order1;
import org.springframework.ui.Model;

public interface OrdersFindAllView extends IView
		                                           //, StringsArray
{
	static String[][] headers = {{"Id", "UserId", "Status", "ProductsCount", "ProductsTotalPrice", "Created", "Modified" },}; //public final static

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

	//@Override
	static public String render(Model model) {
		model.addAttribute("headers", headers);
		return IView.render(model);
	}

}
