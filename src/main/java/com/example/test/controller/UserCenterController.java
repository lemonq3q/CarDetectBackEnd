package com.example.test.controller;

import com.example.test.entity.UserCenter;
import com.example.test.service.UserCenterService;
import com.example.test.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserCenterController {

    @Autowired
    private UserCenterService userCenterService;

    @GetMapping("fyy/getusermsgbyuserid")
    public UserCenter getUserById(Integer id) {
        return userCenterService.getUserById(id);
    }

    //获取所领导的管理员表单
    @GetMapping("fyy/getadmmsg")
    public List<UserCenter> getEmployeeMsg(Integer id) {
        return userCenterService.getEmployeeMsg(id);
    }

    //创建管理员工
    @PostMapping("fyy/insertusermsg")
    public int insertUserMsg(@RequestBody UserCenter user) {
       return userCenterService.insertUserMsg(user);
    }

    @PostMapping("fyy/updateusermsg")
    public ResponseMessage updateUserMsg(@RequestBody UserCenter user){
        return userCenterService.updateUserMsg(user);
    }

    @GetMapping("fyy/captcha")
    public int postcapychabyphone(String phone,Integer id){
        return userCenterService.postcapychabyphone(phone,id);
    }

    @GetMapping("fyy/updatepassword")
    public int updatePassword(int id,String password){
        return userCenterService.updatePassword(id,password);
    }
}
