package com.example.demo.service;

import com.example.demo.entiy.Sale;
import com.example.demo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class SaleServiceImplement implements SaleService {
    @Autowired
    SaleRepository saleRepository;
    @Override
    public Page<Sale> getList(int page, int limit) {
        return saleRepository.findAll(PageRequest.of(page - 1, limit)) ;
    }

    @Override
    public Sale getDetail(int id) {
        return saleRepository.findById(id).orElse(null);
    }

    @Override
    public Sale create(Sale sale) {
        sale.setDos(Calendar.getInstance().getTimeInMillis());
        return saleRepository.save(sale);
    }

    @Override
    public Sale getById(int id) {
        return saleRepository.findById(id).orElse(null);
    }
}
