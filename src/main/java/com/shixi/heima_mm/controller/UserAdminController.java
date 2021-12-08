package com.shixi.heima_mm.controller;

import com.shixi.heima_mm.pojo.Result;
import com.shixi.heima_mm.pojo.UserAdmin;
import com.shixi.heima_mm.service.IUserAdminService;
import com.shixi.heima_mm.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/admin")
public class UserAdminController {
    @Autowired
    private IUserAdminService userAdminService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/login")
    @ResponseBody
    public Result login(String name , String password){
        UserAdmin userAdmin=userAdminService.login(name,password);
        if(name=="" || password=="")
            return new Result("500","用户名和密码不能为空!",null);
        if(userAdmin == null)
            return new Result("501","用户不存在!",null);
        if(  !userAdmin.getPassword().equals(password))
            return new Result("502","用户名或密码错误!",null);

        String token = JWTUtils.geneJsonWebTokenAdmin(userAdmin);
        redisTemplate.opsForValue().set(token,"loginAdmin",10,TimeUnit.MINUTES);
        return new Result("200","登录成功!",token);
    }
    @PostMapping("/update")
    public Result update(Integer id,String name,String password){
        UserAdmin userAdmin=new UserAdmin();

        if (id<=0)
            return new Result("500","违法操作!",null);
        if(name==null||password==null)
            return new Result("501","用户名或密码不能为空!",null);
        userAdmin.setId(id);
        userAdmin.setName(name);
        userAdmin.setPassword(password);
        userAdminService.update(userAdmin);

        return new Result("200","修改成功!","null");
    }

    @PostMapping("/add")
    public Result add(String name,String password){
        UserAdmin userAdmin=new UserAdmin();
        if(name==null||password==null)
            return new Result("500","用户名或密吗不能为空!",null);
        if(userAdminService.findByName(name))
            return new Result("501","用户名重复!",null);
        userAdmin.setName(name);
        userAdmin.setPassword(password);
        userAdminService.insert(userAdmin);
        return new Result("200","添加管理员成功!",null);
    }

    @PostMapping("del")
    private Result del(Integer id){
        userAdminService.delById(id);
        if (userAdminService.findById(id))
            return new Result("500","删除失败!",null);
        return new Result("200","删除成功!",null);
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