//package com.shixi.heima_mm.TODO;
//
//import com.shixi.heima_mm.TODO.LoginInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurationSupport {
//    @Autowired
//    private LoginInterceptor loginInterceptor;
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor).excludePathPatterns("/trMember/code","/trMember/loginEmail","/trMember/register","/admin/login");
//    }
//}
