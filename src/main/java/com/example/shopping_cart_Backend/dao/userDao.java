package com.example.shopping_cart_Backend.dao;

import com.example.shopping_cart_Backend.model.user;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface userDao extends CrudRepository<user,Integer> {
    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone_number` FROM `user` WHERE `email`=:userEmail",nativeQuery = true)
    List<user> searchUser(@Param("userEmail") String userEmail);
}
