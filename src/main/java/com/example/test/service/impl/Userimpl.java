package com.example.test.service.impl;

import com.example.test.entity.User;
import com.example.test.mapper.UserMapper;
import com.example.test.service.UserService;
import com.example.test.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userimpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String addUser(User user){
        int codeNum = userMapper.findActivationCode(user.getActivationCode());
        int repeatNum = userMapper.findRepeat(user.getPhone(),user.getUsername(),0);
        if(user.getHeadshot().equals("")){
            user.setHeadshot(null);
        }
        if(LoginUtil.verifyActivationCode(user.getActivationCode())==1 && codeNum==0 && repeatNum<1){
            userMapper.addUser(user.getUsername(),user.getPassword(),user.getPhone(),user.getActivationCode(),
                    user.getHeadshot(),user.getFactory(),user.getName(),user.getSex());
            return "succeed";
        }
        return "failed";
    }

    @Override
    public String getCode() {
        int num = 1;
        String activationCode = "";
        //生成不重复的激活码
        while(num>0){
            activationCode = LoginUtil.generateActivationCode();
            num = userMapper.findActivationCode(activationCode);
        }
        return activationCode;
    }

    @Override
    public String modifyUsername(String phone, String username) {
        if(username.equals("")||phone.equals("")) return "failed";
        int nums = userMapper.findUsername(username);
        if(nums<1){
            userMapper.updateUsername(phone,username);
            return "succeed";
        }
        return "failed";
    }

    @Override
    public String modifyPassword(String username, String password) {
        if(username.equals("")||password.equals("")) return "failed";
        int nums = userMapper.updatePassword(username,password);
        if(nums>0){
            return "succeed";
        }
        return "failed";
    }

    @Override
    public String modifyPhone(String username, String phone) {
        if(username.equals("")||phone.equals("")) return "failed";
        int nums = userMapper.updatePhone(username,phone);
        if(nums>0){
            return "succeed";
        }
        return "failed";
    }

    @Override
    public User getUserByPhone(String phone) {
        if(phone.equals("")) return null;
        User user = userMapper.getUserByPhone(phone);
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        if(username.equals("")) return null;
        User user = userMapper.getUserByUsername(username);
        return user;
    }

    @Override
    public String updateUser(User user) {
        try {
            int num = userMapper.findRepeat("null", user.getUsername(),user.getUserid());
            if (num < 1) {
                userMapper.updateUser(user.getUsername(), user.getHeadshot(),user.getFactory(),user.getName(),user.getSex(), user.getUserid());
                return "succeed";
            } else {
                return "failed";
            }
        }catch (Exception e){
            return "failed";
        }
    }
}
