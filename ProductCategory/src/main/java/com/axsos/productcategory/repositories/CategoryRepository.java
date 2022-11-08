package com.axsos.productcategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.axsos.productcategory.models.Category;
import com.axsos.productcategory.models.Product;

public interface CategoryRepository extends CrudRepository<Category,Long> {
	Category findCategoryById(Long id);
	
	
    List<Category> findAll();
    
    
    List<Product> findByproductsContains(Category category);

}
