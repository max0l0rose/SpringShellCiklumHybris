package com.company.controller;

import com.company.model.OrdersViewModel;
import com.company.services.OrdersService;
import com.company.view.OrdersView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ShellComponent
public class OrdersController {
	private final Map<String,Object> session = new HashMap<>();

	@Autowired
	private OrdersService ordersService;

	@ShellMethod(key = {"Orders", "os"}, value = "Show all orders with the sum of the prices of all " +
			                                             "relevant products and their quantity.")
	public String commandOrders(
//			@Size(min = 5, max = 40)
//			@ShellOption() //arity = 3, defaultValue = "deffffff",  help = "Possi"
//					String text,
//			@ShellOption()
//					String text2
	) {
		Model model = new ExtendedModelMap();
		//Helper.getPage(model, session, ordersService, 0, "id", "");

		List<OrdersViewModel> items = ordersService.getView();
		model.addAttribute("list", items);

		return OrdersView.render(model);
	}

}
