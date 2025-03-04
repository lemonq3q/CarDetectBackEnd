package com.example.test.config;

import com.example.test.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    //允许的不被拦截的路径
    public static List<String> asList = Arrays.asList("/upload/**","/file/**","/getData/getRiskRecord","/ros/**");

    //注册拦截器的代码
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //定了asList中定义的路径模式将被排除在拦截器的处理之外
        registry.addInterceptor(loginInterceptor).excludePathPatterns(asList);
    }

}

