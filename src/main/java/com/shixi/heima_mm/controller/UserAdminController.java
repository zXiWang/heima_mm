package com.shixi.heima_mm.controller;

import com.shixi.heima_mm.pojo.Result;
import com.shixi.heima_mm.pojo.UserAdmin;
import com.shixi.heima_mm.service.IUserAdminService;
import com.shixi.heima_mm.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/admin")
public class UserAdminController {
    @Autowired
    private IUserAdminService userAdminService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/adminLogin")
    public Result adminLogin(String name , String password){
        UserAdmin userAdmin=userAdminService.adminLogin(name,password);
        if(userAdminService.adminLogin(name,password) == null) {
            // fail
            return new Result("500","用户名或密码错误!",null);
        } else {
            // SUCCESS
            String token = JWTUtils.geneJsonWebToken(userAdmin);
            //放入到redis中
            redisTemplate.opsForValue().set(token,"login",10, TimeUnit.DAYS);
            return new Result("666","登陆成功!",null);
        }

    }
}
//    function adminLogin(){
//        //1. 获取管理员用户名和密码
//        let email_value = $("#name").val();
//        let code_value = $("#password").val();
//        //2. ajax - post请求
//        $.post('http://localhost:8083/heimamm/adminuser/login',{email:email_value,code:code_value},function(res){
//            console.log(res);
//        })
//    }