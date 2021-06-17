package com.aaronmorgan.products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aaronmorgan.products.models.Category;
import com.aaronmorgan.products.models.Product;
import com.aaronmorgan.products.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository pRepo;
	public ProductService(ProductRepository pRepo) {
		this.pRepo = pRepo;
	}
		
	//Display All
	public List<Product> getAllProducts(){
		return this.pRepo.findAll();
	}
	
	//Display One
	public Product getSingleProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	public Product findProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	//Create
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	//Not In Product
	public List<Product> findProductsNotInCategory(Category category) {
		return this.pRepo.findByCategoriesNotContains(category);
	}
	
	//Associate
	public void addCategoryToProduct(Product product, Category category) {
		List<Category> selectedCategories = product.getCategories();
		selectedCategories.add(category); 
		this.pRepo.save(product);
	}
}