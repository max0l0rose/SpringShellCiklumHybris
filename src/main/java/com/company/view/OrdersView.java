package com.company.view;

import com.company.model.Order;
import com.company.model.OrdersViewModel;
import org.springframework.ui.Model;

public class OrdersView implements IView {

	//@Override
	static public String render(Model model) {
		model.addAttribute("headers", OrdersViewModel.headers);
		return IView.render(model);
	}

}
