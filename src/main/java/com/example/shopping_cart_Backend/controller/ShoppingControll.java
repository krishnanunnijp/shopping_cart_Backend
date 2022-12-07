package com.example.shopping_cart_Backend.controller;

import com.example.shopping_cart_Backend.dao.shoppingDao;
import com.example.shopping_cart_Backend.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ShoppingControll {

    @Autowired
    shoppingDao dao;

    
    @GetMapping("/")
    public List<product> view(){
        return (List<product>) dao.findAll();
    }
}
