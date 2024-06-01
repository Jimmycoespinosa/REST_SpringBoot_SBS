package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.model.Products;
import com.example.service.ProductService;

@Controller
@Slf4j
public class Product_Controller 
{
    @Value("${index.strTitle}")
    private String strTitle;

    @Autowired
    private ProductService stockService;
    
    @GetMapping("/")
    public String index(Model model)
    {
        String strNombre = "Jimmy A. Espinosa A.";
        String strPrueba = "Prueba de Conocimientos BackEnd";
        String strTema = "API REST SPRING BOOT";
        String strContacto = "Contacto: Angela Vargas C.";
        log.info("Estoy ejecutando el controller Spring MVC.");

        Iterable<Products> Inventario = stockService.ListProducts();
        model.addAttribute("strTitle", strTitle);
        model.addAttribute("strNombre", strNombre);
        model.addAttribute("strPrueba", strPrueba);
        model.addAttribute("strTema", strTema);
        model.addAttribute("strContacto", strContacto);
        model.addAttribute("products", Inventario);
        
      return "index";
    }
    
    @GetMapping("/anexar")
    public String anexar(Model model){
        model.addAttribute("products", new Products());
        return "crear";
    }
    
    @PostMapping("/guardar")
    public String guardar(Products producto){
        stockService.SaveProduct(producto);
        return "redirect:/";
    }
    
    @GetMapping("/modificar/{id}")
    public String modificar(Products producto, Model model){
        Products OldProduct = stockService.SearchProduct(producto);
        model.addAttribute("products", OldProduct);
        return "crear";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(Products producto, Model model){
        stockService.DeleteProduct(producto);
        return "redirect:/";
    }
}
