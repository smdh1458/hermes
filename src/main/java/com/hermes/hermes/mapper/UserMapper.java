package com.hermes.hermes.mapper;

import com.hermes.hermes.dto.Product;
import com.hermes.hermes.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.awt.*;
import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAllUsers();
    void insertUser(User user);
    String getImage(int productId);
}