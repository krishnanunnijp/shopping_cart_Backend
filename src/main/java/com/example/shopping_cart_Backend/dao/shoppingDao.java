package com.example.shopping_cart_Backend.dao;

import com.example.shopping_cart_Backend.model.product;
import org.springframework.data.repository.CrudRepository;

public interface shoppingDao extends CrudRepository<product,Integer> {
}
