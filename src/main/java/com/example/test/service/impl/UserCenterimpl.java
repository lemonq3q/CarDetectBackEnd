package com.example.test.service.impl;

import com.example.test.entity.UserCenter;
import com.example.test.mapper.UserCenterMapper;
import com.example.test.service.UserCenterService;
import com.example.test.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.test.util.LoginUtil.generateCaptcha;
import static java.lang.Integer.parseInt;

@Service
public class UserCenterimpl implements UserCenterService {

    @Autowired
    private UserCenterMapper userCenterMapper;
    private  String a;

    @Override
    public UserCenter getUserById(Integer id) {
        if(id==null)
        {
            return null;
        }
        UserCenter _userCenter = userCenterMapper.getUserByUserId(id);
        System.out.println(_userCenter.getUserid());
        return _userCenter;
    }

    @Override
    public List<UserCenter> getEmployeeMsg(Integer id) {
        if(id==null)
        {
            return null;
        }
        int iid = id;
        List<UserCenter> admList= userCenterMapper.getadmbymanagerId(iid);
        return admList;
    }

    @Override
    public int insertUserMsg(UserCenter user) {
        userCenterMapper.insertUserMsg(user.getUsername(),user.getPassword(),user.getPhone(),user.getFactory(),user.getName(),user.getSex(),user.getUseraddress(),user.getManagerid());
        int id= userCenterMapper.getUserIdByPhone(user.getPhone());
        userCenterMapper.insertpower(id,user.getEmployee(),user.getDevice(),user.getModel(),user.getRisk(),user.getInspect());
        return 1;
    }

    @Override
    public ResponseMessage updateUserMsg(UserCenter user) {
        a=String.valueOf(user.getUserid());
        if(a==null||a.equals(""))
        {
            return ResponseMessage.error("error",null);
        }
        userCenterMapper.updateUserMsg(user.getUserid(),user.getUsername(),user.getPhone(),user.getUseraddress());
        System.out.println(user.getUserid()+user.getUsername()+user.getPhone()+user.getUseraddress());
        return ResponseMessage.success("success",null);
    }

    @Override
    public int postcapychabyphone(String phone, Integer id) {
        String code;
        if(id==null||id.equals("")||phone==null||phone.equals(""))
        {
            return 0;
        }
        String getphone= userCenterMapper.getphonebyuserid(phone,id);
        if(getphone.equals(phone))
        {
            code=generateCaptcha();
            return parseInt(code);
        }
        return 0;
    }

    @Override
    public int updatePassword(int id, String password) {
        if(password==null||password.equals(""))
        {
            return 0;
        }
        System.out.println(id);
        System.out.println(password);
        userCenterMapper.updatepasswordbyphone(id,password);
        return 1;
    }
}
