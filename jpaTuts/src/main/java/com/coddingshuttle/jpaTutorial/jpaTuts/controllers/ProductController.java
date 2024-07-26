package com.coddingshuttle.jpaTutorial.jpaTuts.controllers;

import com.coddingshuttle.jpaTutorial.jpaTuts.entities.Product;
import com.coddingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product>  getAllProducts(){
        return  productRepository.findByTitleAndOrderByPrice("Mazza");
    }
}
