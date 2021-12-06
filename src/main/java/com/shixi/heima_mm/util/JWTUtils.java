package com.shixi.heima_mm.util;

import com.shixi.heima_mm.pojo.UserAdmin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtils {
    /**
     * 设置过期时间,一周
     */
    private static final long EXPIRE = 7 * 24 * 60 * 60 * 1000;
    //private static final long EXPIRE = 2000;

    /**
     * 设置秘钥
     */
    private static final String SECRET = "success";//盐值

    /**
     * 令牌前缀
     */
    private static final String TOKEN_PREFIX = "aistar";

    /**
     * 令牌主题 - 无所谓
     */
    private static final String SUBJECT = "admin";

    /**
     * 根据用户信息来生成令牌(token)
     * @param userAdmin
     * @return
     */
    public static String geneJsonWebToken(UserAdmin userAdmin){
        //头部省略不写了
//        {
//            "typ": "JJWT"
//            "alg": "HS256"
//        }
        String token = Jwts.builder().setSubject(SUBJECT)

                .claim("id",userAdmin.getId())//载荷 - 有效信息 - 登录用户的有效信息,是为了校验用户是否登录的信息
                .claim("name",userAdmin.getName())
                .claim("password",userAdmin.getPassword())

                .setIssuedAt(new Date())//颁布时间
                //过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))

                //生成签名 - token值
                //HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(payload), secret)
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();//签名

        token = TOKEN_PREFIX + token;
        return token;
    }

    /**
     * 校验token的方法
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){
        try{
            final Claims claims = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();

            return claims;

        }catch (Exception e){
            return null;
        }
    }
}