package com.example.dao;

import com.example.model.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Products, Long>{
    
}
