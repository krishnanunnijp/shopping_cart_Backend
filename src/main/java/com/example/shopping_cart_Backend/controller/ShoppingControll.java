package com.example.shopping_cart_Backend.controller;

import com.example.shopping_cart_Backend.dao.shoppingDao;
import com.example.shopping_cart_Backend.dao.userDao;
import com.example.shopping_cart_Backend.model.product;
import com.example.shopping_cart_Backend.model.user;
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

    @Autowired
    userDao dao2;


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
    @PostMapping(path = "/addUser",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addUser(@RequestBody user u){
        HashMap<String,String> map=new HashMap<>();
        dao2.save(u);
        map.put("status","success");
        return map;
    }

    @PostMapping(path = "/password",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> updateUser(@RequestBody user u) {
        HashMap<String,String> map=new HashMap<>();
        String userEmail= String.valueOf(u.getEmail());
        map.put( "password",String.valueOf(dao2.searchUser(userEmail).get(0).getPassword()));
        map.put("status","success");
        return map;

    }

}
