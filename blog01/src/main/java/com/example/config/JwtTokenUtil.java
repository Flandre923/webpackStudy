package com.example.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {
    private static final String ClAIN_KEN_USERNAME="sub";
    private static final String CLAIN_KEY_CREATED="created";

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        claims.put(ClAIN_KEN_USERNAME,userDetails.getUsername());
        claims.put(CLAIN_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /**
     * 验证tooken是否可以被刷新
     * @param token
     * @return
     */
    public boolean cenRefresh(String token){
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token){
        Claims claims = getClaimsFormToken(token);
        claims.put(CLAIN_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /**
     * 验证token是否失效
     * @param token
     * @return
     */
    public boolean validateToken(String token,UserDetails userDetails){
        String username = getUserNameFormToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否失效
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token){
        Date expireDate = getExpiredDateFromToken(token);
        return expireDate.before(new Date());
    }

    /**
     * 从token中获得失效时间
     * @param token
     * @return
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFormToken(token);
        return claims.getExpiration();
    }


    /**
     * 从token中获得username
     * @param token
     * @return
     */
    public String getUserNameFormToken(String token){
        String username;
        try {
            Claims claims = getClaimsFormToken(token);
            username = claims.getSubject();
        }catch (Exception e){
            username = null ;
        }
        return username;
    }

    /**
     * 从token中获得用户名字具体 被调用函数
     * @param token
     * @return
     */
    public Claims getClaimsFormToken(String token){
        Claims claims = null;
        try{
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  claims;
    }

    /**
     * 给用户生成一个token
     * @param claims
     * @return
     */
    private String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpitation())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /**
     * 获得token失效时间
     * @return
     */
    private Date generateExpitation(){
        return new Date(System.currentTimeMillis() +expiration*1000);
    }



}
