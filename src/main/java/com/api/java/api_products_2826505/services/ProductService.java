package com.api.java.api_products_2826505.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.java.api_products_2826505.entities.Product;
import com.api.java.api_products_2826505.repositories.ProductRepository;

@Service
public class ProductService {

    //dependencia importanto de Autowired
    @Autowired
    private ProductRepository repository;

    //meotods 
    //Read
    List<Product> FindAll() {

        return (List<Product>) repository.findAll();

    }

}
