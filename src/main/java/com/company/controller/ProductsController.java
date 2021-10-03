package com.company.controller;

import com.company.model.Product;
import com.company.services.ProductService;
import com.company.view.ProductsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@ShellComponent()
public class ProductsController
		//extends SecuredCommand
{
	private final Map<String,Object> session = new HashMap<>();

	@Autowired
	private ProductService productService;


	@ShellMethod(key = {"productsByOrderId", "prodsByOId", "pbo"}, value = "Show products by order id.")
	public String commandProductsByOrderId(
			//@Size(min = 5, max = 40)
			@ShellOption() //arity = 3, defaultValue = "deffffff",  help = "Possi"
					int oid
	)
	{
		Model model = new ExtendedModelMap();

		Iterable<Product> users = productService.findByOrdersId(oid);
		model.addAttribute("list", users);

		return ProductsView.render(model);
	}



	@ShellMethod(key = {"products", "prods", "ps"}, value = "Show all products.")
	public String commandProducts (
//			@Size(min = 5, max = 40)
//			@ShellOption() //arity = 3, defaultValue = "deffffff",  help = "Possi"
//					String text,
//			@ShellOption()
//					String text2
	) {
//		List<User> ulist = new ArrayList<User>() {{
//				add(new User("User1", new Department("Dep1"), Role.USER));
//				add(new User("User2", new Department("Dep1"), Role.USER));
//				add(new User("UserAdmin", new Department("Dep2"), Role.ADMIN));
//		}};
//
//		Object[][] uarr = ulist.stream()
//				.map(u -> u.toStringsArray() )
//				.toArray(size -> new Object[size][]);
//
//		//StringsArray sa = u;os
//		//sampleData[1] = u.toStringsArray();

		Model model = new ExtendedModelMap();
		//Helper.getPage(model, session, userService, 0, "id", "");

		Iterable<Product> users = productService.getAll();
		model.addAttribute("list", users);

		return ProductsView.render(model);
	}

}
