package com.example.test.controller;

import com.example.test.entity.User;;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登陆请求处理
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/upload/addUser")
    public String addUser(@RequestBody User user){
       return userService.addUser(user);
    }

    /**
     * 获取激活码
     * @return
     */
    @GetMapping("/upload/getCode")
    public String getCode(){
        return userService.getCode();
    }

    /**
     * 修改用户名
     * @param phone
     * @param username
     * @return
     */
    @PostMapping("/upload/modifyUsername")
    public String modifyUsername(String phone,String username){
        return userService.modifyUsername(phone,username);
    }

    /**
     * 修改密码
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/upload/modifyPassword")
    public String modifyPassword(String username,String password){
        return userService.modifyPassword(username,password);
    }

    /**
     * 换绑手机
     * @param username
     * @param phone
     * @return
     */
    @PostMapping("/upload/modifyPhone")
    public String modifyPhone(String username,String phone){
        return userService.modifyPhone(username,phone);
    }

    /**
     * 根据手机号获取用户信息
     * @param phone
     * @return
     */
    @GetMapping("/user/getUserByPhone")
    public User getUserByPhone(String phone){
        return userService.getUserByPhone(phone);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @GetMapping("/user/getUserByUsername")
    public User getUserByUsername(String username){
        return userService.getUserByUsername(username);
    }

    /**
     * 修改用户的所有信息
     * @param user
     * @return
     */
    @PostMapping("/user/updateUser")
    public String updateUser(@RequestBody User user) {
       return userService.updateUser(user);
    }

}
