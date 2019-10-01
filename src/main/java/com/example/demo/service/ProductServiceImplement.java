package com.example.demo.service;

import com.example.demo.entiy.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplement implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Page<Product> getList(int page, int limit) {
        return productRepository.findAll(PageRequest.of(page - 1, limit)) ;
    }

    @Override
    public Product getDetail(long prodId) {
        return productRepository.findById(prodId).orElse(null);
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(long prodId) {
        return productRepository.findById(prodId).orElse(null);
    }
}
