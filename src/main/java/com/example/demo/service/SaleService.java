package com.example.demo.service;

import com.example.demo.entiy.Sale;
import org.springframework.data.domain.Page;

public interface SaleService {
    Page<Sale> getList(int page, int limit);

    Sale getDetail(int id);


    Sale create(Sale sale);


    Sale getById(int id);
}
