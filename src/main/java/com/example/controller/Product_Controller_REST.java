package com.example.controller;

import com.example.model.Products;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.dao.ProductDAO;

@RestController
@RequestMapping("/api/v1")
public class Product_Controller_REST {
    @Autowired
    private ProductDAO productDAO;
    
    @PostMapping("product")
    @ResponseStatus(HttpStatus.CREATED)
    public Products CreateProduct(@RequestBody Products produto){
        return productDAO.save(produto);
    }
    
    @PutMapping("product")
    @ResponseStatus(HttpStatus.CREATED)
    public Products UpdateProduct(@RequestBody Products produto){
        return productDAO.save(produto);
    }
    
    @DeleteMapping("product/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteProduct(@PathVariable Long id){
        productDAO.deleteById(id);
    }
    
    @GetMapping("product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Products> ShowById(@PathVariable Long id){
        return productDAO.findById(id);
    }
    
    @GetMapping("products")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Products> ShowAll(){
        return productDAO.findAll();
    }
}
