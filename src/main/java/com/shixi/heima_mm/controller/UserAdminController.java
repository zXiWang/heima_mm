package com.shixi.heima_mm.controller;

import com.shixi.heima_mm.pojo.UserAdmin;
import com.shixi.heima_mm.service.IUserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class UserAdminController {
    @Autowired
    private IUserAdminService userAdminService;

    @PostMapping("/adminLogin")
    public String adminLogin(HttpRequest httpRequest, String name , String password){


        return null;
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