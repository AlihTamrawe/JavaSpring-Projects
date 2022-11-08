package com.axsos.productcategory.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.productcategory.models.Category;
import com.axsos.productcategory.models.Product;
import com.axsos.productcategory.repositories.CategoryRepository;
import com.axsos.productcategory.repositories.ProductRepository;




@Service
public class AppService {
	
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	public AppService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	
	  public List<Product> allProduct() {
	        return productRepository.findAll();
	    }
	    // creates a category
	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }
	    // retrieves a category
	    public Product findProduct(Long id) {
	      
	        if(productRepository.existsById(id)) {
	            return productRepository.findProductById(id);
	        } else {
	            return null;
	        }
	    }
	    
	    
	    public List<Category> allCategory() {
	        return categoryRepository.findAll();
	    }
	    // creates a category
	    public Category createCategory(Category category) {
	        return categoryRepository.save(category);
	    }
	    // retrieves a category
	    public Category findCategory(Long id) {
	        
	        if(categoryRepository.existsById(id)) {
	            return categoryRepository.findCategoryById(id);
	        } else {
	            return null;
	        }
	    }
	    
	    public String addprodtocategory(Long idcategory,Long idproduct)  {
	    	Category category = categoryRepository.findCategoryById(idcategory);
	    	Product product = productRepository.findProductById(idproduct);
	    	List<Product> products =    category.getProducts();
	    	products.add(product);
	    	category.setProducts(products);
	    	categoryRepository.save(category);
	    	return "added";
	    }
	    public String addcategorytoprod(Long idcategory,Long idproduct)  {
	    	Category category = categoryRepository.findCategoryById(idcategory);
	    	Product product = productRepository.findProductById(idproduct);
	    	List<Category> categories = product.getCategories();
	    	categories.add(category);
	    	product.setCategories(categories);
	    	categoryRepository.save(category);
	    	return "added";
	    }
	    public List<Category> categoryinproduct(Long id)  {
	    	return 	 productRepository.findBycategoriesNotContains(findProduct(id));

	    }
	    public List<Product> productincategory(Long id)  {
	    	return 	 categoryRepository.findByproductsContains(findCategory(id));

	    }
	

}
