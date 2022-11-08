package com.axsos.productcategory.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.productcategory.models.Category;
import com.axsos.productcategory.models.Product;
import com.axsos.productcategory.services.AppService;

@Controller
public class AppController {
	private final AppService appService;

	public AppController(AppService appService) {
		this.appService = appService;
	}
	
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("products", appService.allProduct());
		model.addAttribute("categories", appService.allCategory());
		
		return "index.jsp";

	}
	@GetMapping("/product")
	public String createProduct(@ModelAttribute("product")Product product)
	{
		
		return "/product/product.jsp";

	}
	@GetMapping("/category")
	public String createCategroy(@ModelAttribute("category")Category category)
	{
		
		return "/category/category.jsp";

	}
	@PostMapping("/product/new")
	public String newproduct(@Valid @ModelAttribute("product")Product product,BindingResult result) {
		
		if(result.hasErrors()) {
			return "/product/product.jsp";
		}else {
			appService.createProduct(product);
			return "redirect:/";
		}
	}
	@PostMapping("/category/new")
	public String newcategory(@Valid @ModelAttribute("category")Category category,BindingResult result) {
		
		if(result.hasErrors()) {
			return "/category/category.jsp";
		}else {
			appService.createCategory(category);
			return "redirect:/";
		}
	}
	@GetMapping("/product/{id}")
	public String addcategorytoProduct(@PathVariable("id") Long id,Model model)
	{
		model.addAttribute("product", appService.findProduct(id));
		List<Category> l1 =  appService.findProduct(id).getCategories();
		List<Category> l3 =  appService.allCategory();
		int c=0;
		
		
		
		for(Category cat:l3) {
			if( l1.contains(cat)) {
				l3.remove(cat);
			}
			c++;
		}
		
		model.addAttribute("categories",l3);
		
		return "/product/productnew.jsp";

	}
	@GetMapping("/category/{id}")
	public String addproducttoCategroy(@PathVariable("id") Long id,Model model)
	{
		model.addAttribute("category",appService.findCategory(id));
		List<Product> l1 =  appService.findCategory(id).getProducts();
		List<Product> l3 =  appService.allProduct();
		int c=0;
		for(Product cat:l3) {
			if( l1.contains(cat)) {
				l3.remove(cat);
			}
			c++;
		}
		
		model.addAttribute("products",l3);
		
		return "/category/categorynew.jsp";

	}
	@PostMapping("/category/prod")
	public String producttoCategroy(@RequestParam("pro")Long id1,@RequestParam("cat")Long id2)  {
		
		appService.addprodtocategory(id2, id1);
		return "redirect:/";
	}
	@PostMapping("/product/cat")
	public String categroytoProduct(@RequestParam("pro")Long id1,@RequestParam("cat")Long id2) {
	  appService.addcategorytoprod(id2, id1);
		return "redirect:/";

	}
	
	
}
