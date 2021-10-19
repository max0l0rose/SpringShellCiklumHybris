package com.company.view;

import com.company.model.Order1;
import org.springframework.ui.Model;

public interface AddOrderView extends IView
		                                           //, StringsArray
{
//	static String[][] headers = {{"Id", "UserId", "Status", "ProductsCount", "ProductsTotalPrice", "Created", "Modified" },}; //public final static
//
//	Order1 getOrder();
//	int getProdsCount();
//	Integer getProdsTotalPrice();
//
//	//MoreObjects.firstNonNull(x, -1);
//	default String[] toStringsArray() {
//		Order1 order = getOrder();
//		return new String[] {
//				String.valueOf(order.getId()),
//				String.valueOf(order.getUser() != null ? order.getUser().getId() : null),
//				String.valueOf(order.getStatus()),
//				String.valueOf(getProdsCount()),
//				String.valueOf(getProdsTotalPrice()),
//				String.valueOf(order.getCreated()), String.valueOf(order.getModified())
//		};
//	}
//
//	//@Override
//	static public String render(Model model) {
//		model.addAttribute("headers", headers);
//		return IView.render(model);
//	}

}
