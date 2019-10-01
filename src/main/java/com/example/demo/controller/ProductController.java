package com.example.demo.controller;

import com.example.demo.entiy.Product;
import com.example.demo.entiy.Sale;
import com.example.demo.service.ProductService;
import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String showListProd(Model model) {
        model.addAttribute("listProduct",productService .getList(1, 10));
        return "list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "form";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String storeAccount(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        productService.create(product);
        return "success";
    }
}
