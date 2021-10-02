package com.company.controller;

import com.company.model.Order;
import com.company.services.OrdersService;
import com.company.view.OrdersView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@ShellComponent
public class OrdersController {
	private final Map<String,Object> session = new HashMap<>();

	@Autowired
	private OrdersService ordersService;

	@ShellMethod(key = {"Orders", "os"}, value = "Show orders...")
	public String commandOrders(
//			@Size(min = 5, max = 40)
//			@ShellOption() //arity = 3, defaultValue = "deffffff",  help = "Possi"
//					String text,
//			@ShellOption()
//					String text2
	) {
		Model model = new ExtendedModelMap();
		//Helper.getPage(model, session, ordersService, 0, "id", "");

		Iterable<Order> users = ordersService.getAll();
		model.addAttribute("list", users);

		return OrdersView.render(model);
	}

}
