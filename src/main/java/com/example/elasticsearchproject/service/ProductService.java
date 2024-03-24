package com.example.elasticsearchproject.service;

import com.example.elasticsearchproject.entity.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);

    public Product getProduct(String id);

    public void deleteProduct(String id);

    public List<Product> addAllProducts(List<Product> products);

    public Product searchProductByName(String name);
}
