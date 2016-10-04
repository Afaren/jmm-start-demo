package com.tw.rs.mapper;

import com.tw.rs.bean.User;

import java.util.List;

/**
 * Created by afaren on 10/3/16.
 */
public interface UserMapper {
    User getUserById(int id);
    List<User> getAllUsers();
}
