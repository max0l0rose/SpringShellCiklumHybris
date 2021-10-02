package com.company.view;

import com.company.model.Order;
import org.springframework.ui.Model;

public class OrdersView implements IView {

	//@Override
	static public String render(Model model) {
		model.addAttribute("headers", Order.headers);
		return IView.render(model);
	}

}
