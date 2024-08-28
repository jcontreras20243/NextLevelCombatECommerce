package com.contrerasjose.ecommercemanagement.ecommercemgt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contrerasjose.ecommercemanagement.ecommercemgt.service.MyMerchandiseService;

@Controller
public class MyMerchandiseController {

    @Autowired
    private MyMerchandiseService service;

@RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id){
        service.deleteById(id);
        return"redirect:/My_Merchandise";
    }
}
