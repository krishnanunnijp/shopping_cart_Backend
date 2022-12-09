package com.example.shopping_cart_Backend.controller;

import com.example.shopping_cart_Backend.dao.shoppingDao;
import com.example.shopping_cart_Backend.dao.userDao;
import com.example.shopping_cart_Backend.model.product;
import com.example.shopping_cart_Backend.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
public class ShoppingControll {

    @Autowired
    shoppingDao dao;

    @Autowired
    userDao dao2;

@CrossOrigin(origins = "*")
    @GetMapping("/")
    public List<product> view(){
        return (List<product>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> add(@RequestBody product p){
        HashMap<String,String> map=new HashMap<>();
        dao.save(p);
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addUser",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addUser(@RequestBody user u){
        HashMap<String,String> map=new HashMap<>();
        System.out.println(u.toString());
        dao2.save(u);
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/password",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> updateUser(@RequestBody user u) {
        HashMap<String,String> map=new HashMap<>();
        String userEmail= String.valueOf(u.getEmail());
        List<user> pr= dao2.searchUser(u.getEmail(),u.getPassword());
        if(pr.size()!=0){
        map.put("status","success");
        map.put("id",String.valueOf(pr.get(0).getId()));}else {
            map.put("status", "user not found");
        }
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<product> searchP(@RequestBody product p) {

        String productName= String.valueOf(p.getName());
        System.out.println(productName);
        return (List<product>) dao.searchProduct(productName);

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchuser",consumes = "application/json",produces = "application/json")
    public List<user> searchU(@RequestBody user u) {

        String userId= String.valueOf(u.getId());
        System.out.println(userId);
        return (List<user>) dao2.searchUser(u.getId());

    }

}
