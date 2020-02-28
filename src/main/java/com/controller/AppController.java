package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.SaleDao;
import com.sale.Sale;

@Controller
public class AppController {

	@Autowired
	private SaleDao saledao;
	
	@RequestMapping("/")
	public String ViewHomePage(Model model){
		
		System.out.println("app controller");
		
		List<Sale> listsale = saledao.list();
		model.addAttribute("listsale",listsale);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String ShowNewForm(Model model){
		
		Sale sale = new Sale();
		model.addAttribute("sale", sale);
		
		return "new_form";
	}
	
	@RequestMapping(value ="/save" , method = RequestMethod.POST)
	public String save(@ModelAttribute("sale") Sale sale) {
		
		saledao.save(sale);
		return "redirect:/";	
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView ShowEditFrom(@PathVariable(name ="id") int id){

		ModelAndView model = new ModelAndView("edit_from");
		
		Sale sale = saledao.get(id);
		model.addObject("sale",sale);
		
		return model;
	}
	
	@RequestMapping(value ="/update" , method = RequestMethod.POST)
	public String update(@ModelAttribute("sale") Sale sale) {
		
		saledao.update(sale);
		return "redirect:/";	
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name ="id") int id){

		saledao.delete(id);
		
		return "redirect:/";
	}
	
}
