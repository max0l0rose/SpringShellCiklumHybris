package com.company.view;

import com.company.model.Product;
import org.springframework.ui.Model;

public class ProductsView implements IView {

	//@Override
	static public String render(Model model) {
		model.addAttribute("headers", Product.headers);
		return IView.render(model);
	}

}
