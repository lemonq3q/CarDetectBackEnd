package com.example.test.service;

import com.example.test.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {

    public String addUser(@RequestBody User user);

    public String getCode();

    public String modifyUsername(String phone,String username);

    public String modifyPassword(String username,String password);

    public String modifyPhone(String username,String phone);

    public User getUserByPhone(String phone);

    public User getUserByUsername(String username);

    public String updateUser(@RequestBody User user);
}
