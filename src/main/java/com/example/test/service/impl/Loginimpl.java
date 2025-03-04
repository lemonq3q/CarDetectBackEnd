package com.example.test.service.impl;

import com.alibaba.fastjson.JSON;
import com.apistd.uni.Uni;
import com.apistd.uni.UniException;
import com.apistd.uni.UniResponse;
import com.apistd.uni.sms.UniMessage;
import com.apistd.uni.sms.UniSMS;
import com.example.test.entity.User;
import com.example.test.interceptor.LoginInterceptor;
import com.example.test.mapper.UserMapper;
import com.example.test.service.LoginService;
import com.example.test.util.LoginUtil;
import com.example.test.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class Loginimpl implements LoginService {

    //API身份验证或授权                      该值为在使用UniSMS的平台时本人身份的唯一标识
    public static String ACCESS_KEY_ID = "maLZzUmMkp8bK5FSzxE3ig6qCLYBEpfE6yoc6pvHqsGUF7Mzz";

    //@Autowired 通常用于注入Spring管理的bean
    @Autowired
    private UserMapper userMapper;

    @Override
    public String Login(String username, String phone) {
        //生成一个随机的UUID字符串，用作用户的token
        String token = UUID.randomUUID().toString();

        int userid = 0;
        User user = null;
        if(phone!=null){
            user = userMapper.getUserByPhone(phone);
        }
        if(username!=null) {
            user = userMapper.getUserByUsername(username);
        }
        //获取查询到的用户的ID
        if(user!=null){
            userid = user.getUserid();
        }

        //将生成的token（随机生成的UUID字符串）和用户ID添加到某个拦截器或管理器中，用于后续的身份验证或会话管理
        LoginInterceptor.addToken(token,userid);

        //将成功响应的信息转换成JSON字符串并返回
        return JSON.toJSONString(ResponseMessage.success(token,user));
    }

    @Override
    public String autoLogin(String token) {
        //调用LoginInterceptor类的一个静态方法getTokenMessage，传入参数token
        //getTokenMessage方法返回一个Pair对象，这是一个泛型类，包含两个元素：
        // 一个Timestamp类型的时间和一个Integer类型的对象ID
        LoginInterceptor.Pair<Timestamp,Integer> tokenMessage= LoginInterceptor.getTokenMessage(token);
        if(tokenMessage!=null){
            //获取用户信息并返回
            User user = userMapper.getUserById(tokenMessage.second);
            return JSON.toJSONString(ResponseMessage.success("userid",user));
        }
        return JSON.toJSONString(ResponseMessage.error("this user had not login",null));
    }

    @Override
    public String upload(String username, String password) {
        int num = userMapper.selectUser(username,password);
        if(num==0){
            return "failed";
        }
        return "succeed";
    }

    @Override
    public String exitLogin(String token){
        LoginInterceptor.removeToken(token);
        return JSON.toJSONString(ResponseMessage.success(null,null));
    }

    @Override
    public String getCaptcha(String phone, int isVerify) {
        if(isVerify==1){
            int num = userMapper.findUserByPhone(phone);
            if(num<=0){
                return "failed";
            }
        }

        //调用工具类的generateCaptcha方法获取一个验证码
        String captcha = LoginUtil.generateCaptcha();

        //初始化发送短信的UniSMS服务，ACCESS_KEY_ID为认定密钥
        Uni.init(ACCESS_KEY_ID);

        //存储短信模板的数据？？
        Map<String ,String> templateData = new HashMap<String ,String>();

        templateData.put("code",captcha);
        templateData.put("ttl","5");

        //创建UniMessage对象，用于构建短信消息
        UniMessage message = UniSMS.buildMessage()
                .setTo(phone)//接收方手机号
                .setSignature("李明玉")//短信签名
                .setTemplateId("pub_verif_ttl2")//短信模板ID
                .setTemplateData(templateData);//短信内容

        try{
            //发送短信并获取相应对象（发送消息后收到的响应）
            UniResponse res = message.send();
            System.out.println(res);
        }catch (UniException e){
            return "failed";
        }
        return captcha;
    }
}
