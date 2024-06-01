package com.example.service;

import com.example.model.Products;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.dao.ProductDAO;

@Service
public class ProductServiceImplement implements ProductService{

    @Autowired
    private ProductDAO productDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Products> ListProducts() {
        return (List<Products>) productDAO.findAll();
    }

    @Override
    @Transactional
    public void SaveProduct(Products producto) {
        productDAO.save(producto);
    }

    @Override
    @Transactional
    public void DeleteProduct(Products producto) {
        productDAO.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Products SearchProduct(Products producto) {
        return productDAO.findById(producto.getId()).orElse(null);
    }    
}
