package com.aaronmorgan.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aaronmorgan.products.models.Category;
import com.aaronmorgan.products.models.Product;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category>findAll();
	List<Category>findByProductsNotContains(Product product);
}
