//package com.shixi.heima_mm.TODO;
//
//import com.alibaba.fastjson.JSONObject;
//import com.shixi.heima_mm.pojo.Result;
//import com.shixi.heima_mm.util.JWTUtils;
//import io.jsonwebtoken.Claims;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.PrintWriter;
//
///**
// * 本类用来演示: 登录的拦截器
// *
// * @author: success
// * @date: 2021/12/3 3:37 下午
// */
//@Component
//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//    /**
//     * 进入控制层方法之前
//     * @param request
//     * @param response
//     * @param handler
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("拦截器...");
//        //return true // 放行
//        //return false // 拦截
//
//        //if ... else ...
//
//        //1. 获取请求过来的头信息中的header中的token
//        String token = request.getHeader("token");
//        System.out.println("token:"+token);
//        //没有进行登录
//        if(token.equals("null")) {
//            System.out.println("=============");
//            //response.sendRedirect("http://localhost:8083/shop/views/user/login.html");
//            //需要手动将java对象转换成json字符串
//
//            //1. 设置输出文档类型
//            response.setContentType("text/json;charset=utf-8");
//            //获取文档输出流
//            PrintWriter out = response.getWriter();
//
//            Result result = new Result("404","请你先登录!",null);
//
//            String jsonStr = JSONObject.toJSONString(result);
//
//            //返回给客户端
//            out.print(jsonStr);
//
//            return false;//拦截...
//        }
//
//        //2. 判断一下redis中是否还存在这个token - redis设置了过期时间
//        if(redisTemplate.opsForValue().get(token) == null)
//            return false;
//
//        //2. token不为null的情况
//        //解析一下token
//        Claims claims = JWTUtils.checkJWT(token.replace("heima",""));
//        if(claims == null)
//            return false;
//
//        //3. 取出载荷中的数据
//        Integer id = claims.get("id",Integer.class);
//        //将这个id放入到request作用去中
//        request.setAttribute("userId",id);
//
//
//        return true;
//    }
//
//    /**
//     * 进入控制层方法之后,但是在该方法结束之前
//     * @param request
//     * @param response
//     * @param handler
//     * @param modelAndView
//     * @throws Exception
//     */
////    @Override
////    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
////
////    }
//
//    /**
//     * 控制层方法执行之后执行
//     * @param request
//     * @param response
//     * @param handler
//     * @param ex
//     * @throws Exception
//     */
////    @Override
////    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
////
////    }
//}
