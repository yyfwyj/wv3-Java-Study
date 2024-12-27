package org.example.webauthorize.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.example.webpojo.admin.dto.AdminUserDTO;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

public class JwtUtil {
    // 秘钥，用于签名和验证JWT
    private static final SecretKey secretKey = Keys.hmacShaKeyFor("wx3JavaStudyJwtUtil".getBytes());

    // 生成Token
    public String generateToken (AdminUserDTO user) {
        return Jwts.builder()
                .setSubject(user.getUsername()) // 设置主题用户名
                .claim("userId",user.getId()) // 添加用户ID作为私有声明
                .setIssuedAt(new Date()) // 设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 设置Token过期时间
                .signWith(secretKey, SignatureAlgorithm.HS256) // 使用HS256算法进行签名
                .compact(); // 生成紧凑型表示形式
    }

    // 验证Token
    public Boolean validateToken (String token,AdminUserDTO user) {
        final String subject = getUsernameFromToken(token);
        return (subject.equals(user.getUsername()) && !isTokenExpired(token));
    }

    // 从token中获取用户名
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    // 检查token是否已经过期
    public Boolean isTokenExpired(String token){
        final Date ExpiredTime = getExpirationDateFromToken(token);
        return ExpiredTime.before(new Date());
    }

    // 从token中获取过期时间
    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }

    // 通用方法，用于从Token中提取声明（claims）
    public <T> T getClaimFromToken(String token, Function<Claims,T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // 获取所有声明(claims)信息
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
