package com.company.view;

import com.company.model.Order1;
import com.company.model.Product;
import org.springframework.ui.Model;

public interface ProductsByOrderView extends IView {

	public final static String[][] headers = {{"ProdId", "Name", "Price", "Status", "Count", "Created", "Modified" },};

//	default String[][] getHeaders() {
//		String[][] headers = {{"Id", "ProdName", "Price", "Status", "Count", "Created", "Modified"},};
//		return headers;
//	}

	Product getProduct();
	int getQuantity();

	//MoreObjects.firstNonNull(x, -1);
	default String[] toStringsArray() {
		Product prod = getProduct();
		return new String[] {
				String.valueOf(prod.getId()),
				String.valueOf(prod.getName()),
				String.valueOf(prod.getPrice()),
				String.valueOf(prod.getStatus()),
				String.valueOf(getQuantity()),
				String.valueOf(prod.getCreated()), String.valueOf(prod.getModified())
		};
	}

	//@Override
	static public String render(Model model) {
		model.addAttribute("headers", headers);
		return IView.render(model);
	}

}
