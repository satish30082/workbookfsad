package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Product;
import com.klu.repo.ProductRepository;

@Service
public class ProductService 
{

    @Autowired
    ProductRepository repo;

    public List<Product> getByCategory(String category)
    {
        return repo.findByCategory(category);
    }

    public List<Product> getByPriceRange(double min,double max)
    {
        return repo.findByPriceBetween(min,max);
    }

    public List<Product> getSortedProducts()
    {
        return repo.getProductsSortedByPrice();
    }

    public List<Product> getExpensiveProducts(double price)
    {
        return repo.getExpensiveProducts(price);
    }
}