package com.company.controller;
//
//import com.example.springconsoleappdi.services.MyPagedService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.ui.Model;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//public class Helper {
//
//	public static <T> void getPage(Model model,
//							   Map<String, Object> session,
//							   MyPagedService<T> service,
//							   int pageNumber,
//							   String sortIn,
//							   String sortDirIn) {
////		String sesSort = Optional.ofNullable((String)session.get("sort")).orElse("");
////		if (sort == null)
////			sort = "";
////		if (sort.equals(""))
////			sort = sesSort;
//
//
//		String sesSort = (String)session.get("sort");
//		String sort = Optional.ofNullable(sortIn).orElse(
//			Optional.ofNullable(sesSort).orElse("")
//		);
//
//
////		//assert null != null;
////
////		if (sortDir.equals(""))
////			sortDir = (sortDir = (String) session.get("sortDir")) != null ? sortDir : "";
//
//		String sortDir = Optional.ofNullable(sortDirIn).orElse(
//				Optional.ofNullable((String)session.get("sortDir")).orElse("")
//		);
//
//
//		Integer pn = (Integer) session.get("pageNumber");
//
//		if (!sort.equals(sesSort))
//			sortDir = "asc";
//		else
//			if (pn == null || pn == pageNumber)
//				sortDir = sortDir.equals("asc") ? "desc" : "asc";
//
//		Pageable pageable =
//				PageRequest.of(pageNumber, 6,
//						sortDir.equals("asc") ? Sort.by(sort).ascending() : Sort.by(sort).descending());
////				PageRequest.of(0, 5, Sort.by("price").descending().and(Sort.by("name")))
//		Page<T> page = service.getPage(pageable);
//		model.addAttribute("pageNumber", pageNumber);
//		List list = page.getContent();
//		model.addAttribute("list", list);
//		model.addAttribute("totalElements", page.getTotalElements());
//		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("title", "INDEX");
//
//		model.addAttribute("sort", sort);
//		model.addAttribute("sortDir", sortDir);
//
//		session.put("sort", sort);
//		session.put("sortDir", sortDir);
//		session.put("pageNumber", pageNumber);
//	}
//}
