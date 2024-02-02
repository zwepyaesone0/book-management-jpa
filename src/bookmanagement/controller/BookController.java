package bookmanagement.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import bookmanagement.model.DataBean;
import bookmanagement.persistant.dao.bookDAO;
import bookmanagement.persistant.dto.BookDTO;


@Controller
public class BookController {
	@Autowired
	private bookDAO dao;// dao class name
	
	@GetMapping("/")
	public String displayView(Model model) {
		List<BookDTO> list= dao.selectAll();
		model.addAttribute("list",list);
		return "displaybook";
	}
	
	@GetMapping("/setupaddbook")
	public ModelAndView setupaddbook() {
		return new ModelAndView("addBook","bean",new DataBean());
	}
	
	@PostMapping("/addbook")
	public String addbook(@ModelAttribute("bean") @Validated DataBean bean , BindingResult bs,ModelMap model) {
		if(bs.hasErrors()){
			return "addBook";
		}
		BookDTO dto=new BookDTO();
		dto.setBookCode(bean.getBookCode());
		dto.setBookAuthor(bean.getBookAuthor());
		dto.setBookTitle(bean.getBookTitle());
		dto.setBookPrice(Double.valueOf(bean.getBookPrice()));
		int result=dao.insert(dto);
		if(result==0) {
			model.addAttribute("error","Insert Failed");
			return "addBook";
		}
		return "redirect:/";
	
	}
	@GetMapping("/setupUpdateBook/{bookCode}")
	public ModelAndView setupUpdateBook(@PathVariable String bookCode) {
		BookDTO dto=new BookDTO();
		dto.setBookCode(bookCode);
		return new ModelAndView("updatebook","bean",dao.selectOne(dto).get(0));
	}
	@PostMapping("/updatebook")
	public String updatebook(@ModelAttribute("bean") @Validated DataBean bean , BindingResult bs,Model model) {
		if(bs.hasErrors()){
			return "updatebook";
		}
		BookDTO dto=new BookDTO();
		dto.setBookCode(bean.getBookCode());
		dto.setBookAuthor(bean.getBookAuthor());
		dto.setBookTitle(bean.getBookTitle());
		dto.setBookPrice(Double.valueOf(bean.getBookPrice()));
		int result=dao.update(dto);
		if(result==0) {
			model.addAttribute("error","Update Failed!!");
			return "updatebook";
		}
		return "redirect:/";
	
	}
	@GetMapping("/deletebook/{bookCode}")
	public String deletebook(@PathVariable String bookCode,Model model) {
		BookDTO dto=new BookDTO();
		dto.setBookCode(bookCode);
		int result=dao.delete(dto);
		if(result==0) {
			model.addAttribute("error","Delete Failed!!");
			return "/";
		}
		return "redirect:/";
	
	}
	

}
