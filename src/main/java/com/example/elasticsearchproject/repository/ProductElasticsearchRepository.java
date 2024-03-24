package com.example.elasticsearchproject.repository;

import com.example.elasticsearchproject.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("productElasticsearchRepository")
public interface ProductElasticsearchRepository extends ElasticsearchRepository<Product,String> {
   public Product searchProductByName(String name);
}
