package com.example.demo.service;

import com.example.demo.entiy.Product;
import com.example.demo.entiy.Sale;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<Product> getList(int page, int limit);

    Product getDetail(long prodId);


    Product create(Product product);


    Product getById(long prodId);
}
