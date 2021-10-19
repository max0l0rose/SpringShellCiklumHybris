package com.company.view;

import com.company.model.StringsArray;
import org.springframework.shell.table.*;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface IView extends StringsArray {

//	default String[][] getHeaders() {
//		return null;
//	}

	static String render(Model model) {

		String result= (String) model.getAttribute("caption") + System.lineSeparator();
		//System.out.println(caption);

		String body = (String) model.getAttribute("body");
		if (body != null)
			result += body + System.lineSeparator(); //System.out.println(body);

		Iterable<StringsArray> items = (Iterable)model.getAttribute("list");
		if (items == null)
			return result;

		String[][] headers = (String[][])model.getAttribute("headers");
//				.forEach(q -> {
//							Arrays.stream(q)
//									.forEach(a -> System.out.print(a + " "));
//							System.out.println(": " + Arrays.stream(q).count());
//						}
//				);

		Object[][] headersAndData = Stream.concat(
						Arrays.stream(headers),
						StreamSupport.stream(items.spliterator(), false) // stream
							.map(u -> u.toStringsArray())
				)
				.toArray(size -> new Object[size][]);

		TableModel tableModel = new ArrayTableModel(headersAndData);
		TableBuilder tableBuilder = new TableBuilder(tableModel);
		tableBuilder.addInnerBorder(BorderStyle.fancy_light).addHeaderBorder(BorderStyle.fancy_double);
				//.on(CellMatchers.column(0)).addWrapper(new KeyValueTextWrapper()).addSizer(new AbsoluteWidthSizeConstraints(20))
				//.on(CellMatchers.column(1)).addSizer(new AbsoluteWidthSizeConstraints(30));
				//.on(CellMatchers.column(2)).addSizer(new AbsoluteWidthSizeConstraints(50));
		//tableBuilder.on(CellMatchers.ofType(LocalDate.class)).addFormatter(dateFormatter);

		return result + tableBuilder.build().render(80);
	}
}
