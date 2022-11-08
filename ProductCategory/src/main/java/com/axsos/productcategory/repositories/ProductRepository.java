package com.axsos.productcategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.productcategory.models.Category;
import com.axsos.productcategory.models.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    Product  findProductById(Long Id);
    List<Product> findAll();

   
    }
