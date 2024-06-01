package com.example.service;

import com.example.model.Products;
import java.util.List;

public interface ProductService {
    public List<Products> ListProducts();
    public void SaveProduct(Products producto);
    public void DeleteProduct(Products producto);
    public Products SearchProduct(Products producto);
}
