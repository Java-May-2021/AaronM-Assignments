package com.aaronmorgan.products.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aaronmorgan.products.models.Category;
import com.aaronmorgan.products.models.Product;
import com.aaronmorgan.products.services.CategoryService;
import com.aaronmorgan.products.services.ProductService;



@Controller
public class MainController {
	
	@Autowired
	private CategoryService cService;
	
	@Autowired
	private ProductService pService;
	
	@RequestMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("allProducts", this.pService.getAllProducts());
		viewModel.addAttribute("allCategories", this.cService.getAllCategories());
		return "index.jsp";
	}
	
	// PRODUCTS
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product, Model model) {
		return "newProduct.jsp";
	}
	@RequestMapping(value="/products/create", method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}
		this.pService.createProduct(product);
		return "redirect:/";
	}
	@GetMapping("products/{id}")
	public String viewProduct(@ModelAttribute("product") Product product, Model model, @PathVariable("id") Long id) {
		Product oneProduct = this.pService.findProduct(id);
		model.addAttribute("product", oneProduct);
		List<Category> NotInProduct = cService.findCategoriesNotInProduct(oneProduct);
		model.addAttribute("notInProduct", NotInProduct);
		return "oneProduct.jsp";
	}
	@PostMapping("/products/{id}")
	public String addCategoryToProduct(@RequestParam("category") Long cId, @PathVariable("id") Long pId) {
		
		Product oneProduct = pService.findProduct(pId);
		Category oneCategory = cService.findCategory(cId);
		pService.addCategoryToProduct(oneProduct, oneCategory);
		return "redirect:/products/" + pId;
	}
	
	// CATEGORIES
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category, Model model) {
		return "newCategory.jsp";
	}
	@RequestMapping(value="/categories/create", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}
		this.cService.createCategory(category);
		return "redirect:/";
	}


	@GetMapping("categories/{id}")
	public String viewCategory(@ModelAttribute("category") Category category, Model model, @PathVariable("id") Long id) {
		Category oneCategory = this.cService.findCategory(id);
		model.addAttribute("category", oneCategory);
		List<Product> NotInCategory = pService.findProductsNotInCategory(oneCategory);
		model.addAttribute("notInCategory", NotInCategory);
		return "oneCategory.jsp";
	}
	@PostMapping("/categories/{id}")
	public String addProductToCategory(@RequestParam("product") Long pId, @PathVariable("id") Long cId) {
		
		Category oneCategory = cService.findCategory(cId);
		Product oneProduct = pService.findProduct(pId);
		pService.addCategoryToProduct(oneProduct, oneCategory);
		return "redirect:/categories/" + cId;
	}
}
