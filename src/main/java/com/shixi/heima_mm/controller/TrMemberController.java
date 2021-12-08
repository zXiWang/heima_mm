package com.shixi.heima_mm.controller;

import com.shixi.heima_mm.pojo.Result;
import com.shixi.heima_mm.pojo.TrMember;
import com.shixi.heima_mm.service.ITrMemberService;
import com.shixi.heima_mm.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/trMember")
public class TrMemberController {
    @Autowired
    private ITrMemberService trMemberService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MailSender mailSender;

    @GetMapping("/code")
    @ResponseBody
    public Result sendCode(String email){

        TrMember trMember = trMemberService.findByEmail(email);
        if(trMember != null){

            int n = (int) (Math.random()*90000 + 10000);
            String code = String.valueOf(n);

            SimpleMailMessage msg = new SimpleMailMessage();

            msg.setFrom("1040331024@qq.com");
            msg.setSubject("驰星");
            msg.setText(code+"          验证码5分钟后过期,请及时登录!");
            msg.setTo(email);

            mailSender.send(msg);
            msg.setText(code);
            ValueOperations vop = redisTemplate.opsForValue();
            vop.set(email,code,5, TimeUnit.MINUTES);
            return new Result("200","验证码发送成功,请您查看邮箱",null);
        }
        return new Result("500","邮箱不存在!",null);
    }

    @PostMapping("/loginPassword")
    @ResponseBody
    public Result loginPassword(String name,String password){
        TrMember trMember = trMemberService.findByName(name);
        if(name==""||password=="")
            return new Result("500","用户名和密码不能为空!",null);
        if(trMember == null)
            return new Result("501","用户不存在!",null);
        if(  !trMember.getPassword().equals(password))
            return new Result("502","用户名或密码错误!",null);

        String token = JWTUtils.geneJsonWebTokenUserPassword(trMember);
        redisTemplate.opsForValue().set(token,"loginPassword",10,TimeUnit.MINUTES);
        return new Result("200","登录成功!",token);
    }

    @PostMapping("/loginEmail")
    @ResponseBody
    public Result loginEmail(String email,String code){
        TrMember trMember = trMemberService.findByEmail(email);
        if(trMember == null)
            return new Result("404","用户不存在!",null);
        String redisCode = (String) redisTemplate.opsForValue().get(email);
        if(  redisCode == null)//过期了...
            return new Result("500","验证码过期了!",null);
        if(!redisCode.equals(code))
            return new Result("400","验证码错误!",null);

        String token = JWTUtils.geneJsonWebTokenUserEmail(trMember);
        redisTemplate.opsForValue().set(token,"loginEmail",10,TimeUnit.MINUTES);
        return new Result("200","登录成功!",token);

    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(String name,String email,String password){
        if(password=="")
            return new Result("503","密码不能为空!",null);
        if(trMemberService.findByName(name)!=null&&trMemberService.findByEmail(email)!=null)
            return new Result("502","用户名重复和邮箱已被注册!",null);
        if(trMemberService.findByName(name)!=null)
            return new Result("500","用户名重复!",null);
        if (trMemberService.findByEmail(email)!=null)
            return new Result("501","邮箱已被注册!",null);
        TrMember trMember=new TrMember();
        trMember.setNickName(name);
        trMember.setEmail(email);
        trMember.setPassword(password);
        trMemberService.insert(trMember);
        return new Result("200","注册成功!",null);
    }

    @PostMapping("/del")
    public Result del(Integer id){
        trMemberService.delById(id);
        if (trMemberService.findById(id))
            return new Result("500","删除失败!",null);
        return new Result("200","删除成功!",null);
    }



}
