package com.example.shopping_cart_Backend.dao;

import com.example.shopping_cart_Backend.model.product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface shoppingDao extends CrudRepository<product,Integer> {
    @Query(value = "SELECT `id`, `category`, `description`, `image`, `name`, `price` FROM `product` WHERE `name`=:productName",nativeQuery = true)
    List<product> searchProduct(@Param("productName") String productName);
}
