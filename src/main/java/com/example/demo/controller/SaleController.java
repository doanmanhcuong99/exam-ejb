package com.example.demo.controller;

import com.example.demo.entiy.Sale;
import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class SaleController {
    @Autowired
    SaleService saleService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String showListSale(Model model) {
        model.addAttribute("list",saleService .getList(1, 10));
        return "list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("sale", new Sale());
        return "form";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String storeAccount(@Valid Sale sale, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        saleService.create(sale);
        return "success";
    }
}
