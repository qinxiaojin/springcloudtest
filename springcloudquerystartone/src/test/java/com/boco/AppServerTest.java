package com.boco;

import static org.junit.Assert.assertTrue;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.JavaWsdlMappingType;
import org.junit.Test;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppServerTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void contextLoads(){
        //Map<String,Object> map = new HashMap<>();

        Calendar calendar =Calendar.getInstance();
        calendar.add(Calendar.SECOND,100); //得到秒数

//创建签名 签名携带header-payment(要传递的内容)-sign 签名（算法加密）
        String sign = JWT.create()
                .withClaim("userid",21)
                .withClaim("username","qinxiaojin")
                .withExpiresAt(calendar.getTime())//指定令牌过期时间
                .sign(Algorithm.HMAC256("ttest"));//签名
        System.out.println(sign);
    }
    @Test
    public void test(){
        //创建验证对象
        JWTVerifier jwtVerifier = JWT.
                require(Algorithm.HMAC256("ttest")).build();
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjE2ODI4OTksInVzZXJpZCI6MjEsInVzZXJuYW1lIjoicWlueGlhb2ppbiJ9.grhZ2QURmaCPaDa2r_ZHwhBUGQMDJ1mUMnfbyuIuinE");
        System.out.println(verify.getClaim("userid").asInt());
        System.out.println(verify.getClaim("username").asString());
    }

    public static void main(String arg[]){
       Integer i = 2;
        System.out.println(i != null );
    }
}
