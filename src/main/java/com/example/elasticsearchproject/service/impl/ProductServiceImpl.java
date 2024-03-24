package com.example.elasticsearchproject.service.impl;

import com.example.elasticsearchproject.entity.Product;
import com.example.elasticsearchproject.repository.ProductElasticsearchRepository;
import com.example.elasticsearchproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
 public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductElasticsearchRepository productElasticsearchRepository;

   /* @Autowired
    private ProductJpaRepository productJpaRepository;*/


    @Override
    public Product addProduct(Product product) {

        product.setId(UUID.randomUUID().toString());
        return productElasticsearchRepository.save(product);

    }

    @Override
    public Product getProduct(String id) {

        Optional<Product> OptProduct = productElasticsearchRepository.findById(id);
        if (OptProduct.isPresent()) {
            return OptProduct.get();
        }
        return null;
    }

    @Override
    public void deleteProduct(String id) {
         productElasticsearchRepository.deleteById(id);

    }

    @Override
    public List<Product> addAllProducts(List<Product> products) {
         List<Product> savedProducts =new ArrayList<>();

         for( Product product: products){
             product.setId(UUID.randomUUID().toString());
            Product savedProduct = productElasticsearchRepository.save(product);
             savedProducts.add(savedProduct);
         }

         return savedProducts;
    }

    @Override
    public Product searchProductByName(String name) {
        return productElasticsearchRepository.searchProductByName(name);
    }


}
