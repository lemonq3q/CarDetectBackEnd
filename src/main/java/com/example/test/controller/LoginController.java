package com.example.test.controller;

import com.alibaba.fastjson.JSON;//用于返回JSON字符串所需的包

//发送信息的
import com.apistd.uni.Uni;
import com.apistd.uni.UniException;//有关报错
import com.apistd.uni.UniResponse;
import com.apistd.uni.sms.UniMessage;
import com.apistd.uni.sms.UniSMS;//发送短信的SMS服务

import com.example.test.entity.User;//所使用的实体类

import com.example.test.interceptor.LoginInterceptor;

import com.example.test.mapper.UserMapper;//所使用的mapper操作方法

//引入的工具类
import com.example.test.service.LoginService;
import com.example.test.util.LoginUtil;//生成验证码
import com.example.test.util.ResponseMessage;//相应消息的实体类型

import org.apache.ibatis.annotations.Options;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

import java.sql.Timestamp;

import java.util.HashMap;
import java.util.Map;

import java.util.UUID;//通用唯一识别码。在Java中，UUID 类用于生成和表示这种全局唯一的标识符

@RestController
//指示类是一个控制器，并且所有的方法都映射为HTTP请求的处理方法。
//该控制器中的方法返回的对象直接作为HTTP响应的正文（Body），而不是返回一个视图（View）。
public class LoginController {

    @Autowired
    private LoginService loginService;

    //API身份验证或授权                      该值为在使用UniSMS的平台时本人身份的唯一标识
    public static String ACCESS_KEY_ID = "maLZzUmMkp8bK5FSzxE3ig6qCLYBEpfE6yoc6pvHqsGUF7Mzz";

    //@Autowired 通常用于注入Spring管理的bean
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册token信息
     * @return
     */
    //处理HTTP的get请求
    //URL的路径是/upload/registerToken
    @GetMapping("/upload/registerToken")
    public String Login(String username,String phone){
        return loginService.Login(username,phone);
    }

    /**
     * 已经登录的用户自动跳转
     * @param token
     * @return
     */
    @GetMapping("/upload/autoLogin")
    //可以登录的用户
    public String autoLogin(String token){
       return loginService.autoLogin(token);
    }

    /**
     * 退出登录
     * @param token
     * @return
     */
    @GetMapping("/upload/exitLogin")
    public String exitLogin(String token){
        return loginService.exitLogin(token);
    }
    /**
     * 判断账号密码是否匹配
     * @param username
     * @param password
     * @return
     */

    @GetMapping("/upload/usernameUpload")
    //在一个控制器（Controller）类的方法上使用@GetMapping时，Spring会自动处理所有匹配指定路径的HTTP GET请求。
    //判断密码是否输入成功
    public String upload(String username,String password){
        return loginService.upload(username,password);
    }

    /**
     * 获取验证码
     * @param phone
     * @return
     */
    @GetMapping("/upload/getCaptcha")
    //isVerify是什么？ 确定是用于登录的发送验证码还是注册的发送验证码
    public String getCaptcha(String phone,int isVerify){
     return loginService.getCaptcha(phone,isVerify);
    }



    //使用某个SMS（短消息服务）API发送短信验证码或通知
    //使用了UniSMS服务，这是一个虚构的API服务，用于说明如何发送短信
    public static void main(String[] args) {

        //初始化UniSMS服务，使用ACCESS_KEY_ID作为认定密钥
        Uni.init(ACCESS_KEY_ID);

        //存储短信模板的数据？？
        Map<String ,String> templateData = new HashMap<String ,String>();

        //在存储短信信息的模板中添加键值对
        templateData.put("code","52783");
        templateData.put("ttl","5");

        //创建一个新的UniMessage对象，用于构建短信消息。
        UniMessage message = UniSMS.buildMessage()
                .setTo("15762502276")//短信接收者的电话号码
                .setSignature("李明玉")//短信签名
                .setTemplateId("pub_verif_ttl2")//短信模板ID，这是短信服务提供商用来识别短信模板的标识符
                .setTemplateData(templateData);//短信模板的数据

        try{
            //发送短信，获取相应对象
            UniResponse res = message.send();
            System.out.println(res);
        }catch (UniException e){
            System.out.println("Error: " + e);

            //requestID是什么？？
            System.out.println("RequestId: " + e.requestId);
        }
    }

}
