package com.example.shopping_cart_Backend.dao;

import com.example.shopping_cart_Backend.model.user;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface userDao extends CrudRepository<user,Integer> {
    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phoneno` FROM `user` WHERE `email`=:userEmail  AND `password`=:password ",nativeQuery = true)
    List<user> searchUser(@Param("userEmail") String userEmail,@Param("password") String password);

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phoneno` FROM `user` WHERE `id` =:id",nativeQuery = true)
    List<user> searchUser(@Param("id") Integer id );
}
