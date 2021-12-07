package com.shixi.heima_mm.util;

import com.shixi.heima_mm.pojo.TrMember;
import com.shixi.heima_mm.pojo.UserAdmin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtils {

    private static final long EXPIRE = 7 * 24 * 60 * 60 * 1000;
    //private static final long EXPIRE = 2000;

    private static final String SECRET = "success";//盐值


    private static final String TOKEN_PREFIX = "heima";

    private static final String SUBJECT = "user";

    public static String geneJsonWebTokenAdmin(UserAdmin userAdmin){
        String token = Jwts.builder().setSubject(SUBJECT)

                .claim("id",userAdmin.getId())//载荷 - 有效信息 - 登录用户的有效信息,是为了校验用户是否登录的信息
                .claim("name",userAdmin.getName())
                .claim("password",userAdmin.getPassword())

                .setIssuedAt(new Date())//颁布时间
                //过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();//签名

        token = TOKEN_PREFIX + token;
        return token;
    }

    public static String geneJsonWebTokenUser(TrMember trMember){
        String token = Jwts.builder().setSubject(SUBJECT)

                .claim("id",trMember.getId())//载荷 - 有效信息 - 登录用户的有效信息,是为了校验用户是否登录的信息
                .claim("email",trMember.getEmail())
                .claim("password",trMember.getPassword())

                .setIssuedAt(new Date())//颁布时间
                //过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();//签名

        token = TOKEN_PREFIX + token;
        return token;
    }

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