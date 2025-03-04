package com.example.test.config;

//启用和配置跨源资源共享（CORS）策略
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//标记并了这个类是一个配置类，Spring容器会在启动时创建这个类的实例将其加入到应用程序的上下文中
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//为所有URL路径（"/**"）添加CORS配置
                .allowedOrigins("*")//设置允许的源（Origins），"*" 表示允许所有域名访问。
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")//设置允许的HTTP方法。
                //get：从服务器获取数据   post：给服务器发送数据
                .maxAge(168000)
                .allowedHeaders("*");//设置允许的HTTP请求头，"*" 表示允许所有请求头。
    }
}
//跨域访问的cors配置
//控制哪些源可以访问
//客户端的HTTP请求的方法和请求头
