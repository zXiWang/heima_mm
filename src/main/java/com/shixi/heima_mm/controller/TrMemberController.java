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

        TrMember trMember = trMemberService.login(email);
        if(trMember != null){

            int n = (int) (Math.random()*90000 + 10000);
            String code = String.valueOf(n);

            SimpleMailMessage msg = new SimpleMailMessage();

            msg.setFrom("1040331024@qq.com");
            msg.setSubject("驰星");
            msg.setText(code+"验证码5分钟后过期,请及时登录!");
            msg.setTo(email);

            mailSender.send(msg);
            msg.setText(code);
            ValueOperations vop = redisTemplate.opsForValue();
            vop.set(email,code,5, TimeUnit.MINUTES);
            return new Result("200","验证码发送成功,请您查看邮箱",null);
        }
        return new Result("500","邮箱不存在!",null);
    }

    @PostMapping("/login")
    @ResponseBody
    public Result login(String email,String code){
        TrMember trMember = trMemberService.login(email);
        if(trMember == null)
            return new Result("404","用户不存在!",null);
        String redisCode = (String) redisTemplate.opsForValue().get(email);
        if(  redisCode == null)//过期了...
            return new Result("500","验证码过期了!",null);
        if(!redisCode.equals(code))
            return new Result("400","验证码错误!",null);

        String token = JWTUtils.geneJsonWebTokenUser(trMember);
        redisTemplate.opsForValue().set(token,"login",10,TimeUnit.MINUTES);
        return new Result("200","登录成功!",token);

    }


}
