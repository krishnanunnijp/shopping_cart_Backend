package com.example.shopping_cart_Backend.controller;

import com.example.shopping_cart_Backend.dao.shoppingDao;
import com.example.shopping_cart_Backend.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
public class ShoppingControll {

    @Autowired
    shoppingDao dao;


    @GetMapping("/")
    public List<product> view(){
        return (List<product>) dao.findAll();
    }
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> add(@RequestBody product p){
        HashMap<String,String> map=new HashMap<>();
        dao.save(p);
        map.put("status","success");
        return map;
    }
}
