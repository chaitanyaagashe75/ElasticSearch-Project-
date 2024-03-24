package com.example.elasticsearchproject.controller;

import com.example.elasticsearchproject.entity.Product;
import com.example.elasticsearchproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PostMapping("/addAll")
    public List<Product> addAllProducts(@RequestBody List<Product> products) {
        return productService.addAllProducts(products);
    }


    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable String id ){
          productService.deleteProduct(id);
    }

    @GetMapping("/searchByName")
    public Product searchProductByName(@RequestParam String name){

        return productService.searchProductByName(name);

    }



}
