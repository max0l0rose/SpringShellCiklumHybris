package com.company.controller;

import com.company.model.Order1;
import com.company.model.ProdStatus;
import com.company.model.Product;
import com.company.repo.OrderItemsRepo;
import com.company.repo.OrdersRepo;
import com.company.repo.ProdRepo;
import com.company.services.ProductService;
import com.company.view.IView;
import com.company.view.OrdersFindAllView;
import com.company.view.ProductsFindAllView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ShellComponent
public class OrdersController {
	private final Map<String,Object> session = new HashMap<>();

	@Autowired
	private OrdersRepo ordersRepo;

	@Autowired
	OrderItemsRepo orderItemsRepo;

	@Autowired
	private ProdRepo prodRepo;

	@Autowired
	private ProductService productService;

	@Autowired
	ProductsController productsController;

	@ShellMethod(key = {"addOrder", "addo", "ao"}, value = "Add an order with array of product ids...")
	@Transactional
	public String commandAddOrder(
//			@Size(min = 5, max = 40)
			@ShellOption(defaultValue = "") //arity = 3, defaultValue = "deffffff",  help = "Possi"
					String idsAndQuantity
//			@ShellOption()
//					String text2
	) {
		Pattern sIdsAndQuantityArrPattern = Pattern.compile("(\\d+)[-\\s]*(\\d+)*"); // example: "1-10 2-20 3 30, 4-40 fghfgh 5 ----  50"
		Matcher matcher = sIdsAndQuantityArrPattern.matcher(idsAndQuantity);

		//ist<Product> productList = new ArrayList<>();

		Order1 order = new Order1(ProdStatus.IN_STOCK);
		ordersRepo.save(order);


		String render = "";
		while(matcher.find()) //for(String sIdAndQ : sIdsAndQuantity)
		{
			String sId = matcher.group(1);
			String sQ = matcher.group(2);
			render += "productId=";
			long productId = Long.valueOf(sId);
			render += productId + ", " + "quantity=";
			int quantity = Integer.valueOf(sQ);
			render += quantity + "; ";
//			OrderItems orderItems = new OrderItems(productId, order.getId(), quantity);
//			orderItemsRepo.save(orderItems);

			Product product = prodRepo.findById(productId).get();//.orElseThrow( () -> new IllegalArgumentException() );
			order.addProduct(product, quantity);
		}
		//ender += System.lineSeparator();

		Model model = new ExtendedModelMap();
		//Helper.getPage(model, session, ordersService, 0, "id", "");

		model.addAttribute("caption", "Adding a new order " + order.getId());
		model.addAttribute("body", render);

		String renderResult = IView.render(model);

//		Iterable<Product> products = prodRepo.findAll();
//		model.addAttribute("list", order.getOrderItems());

		return renderResult + productsController.commandProductsByOrderId(order.getId());
	}




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

		model.addAttribute("caption", "Orders:");

		List<OrdersFindAllView> items = ordersRepo.getAllOrdersView();
		model.addAttribute("list", items);

		return OrdersFindAllView.render(model);
	}

}
