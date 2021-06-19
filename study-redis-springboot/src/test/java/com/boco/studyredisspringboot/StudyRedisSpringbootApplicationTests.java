package com.boco.studyredisspringboot;

import com.boco.studyredisspringboot.conf.RedisConfig;
import com.boco.studyredisspringboot.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class StudyRedisSpringbootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;
    @Test
    void contextLoads() {
        //redisTemplate
        //opsForValue 操作字符串 类似String
        //opsForList 操作list 类似list
        //获取redis的连接对象
        //RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        redisTemplate.opsForValue().set("mykey","qinxiaojin");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }
    @Test
    public void test() throws JsonProcessingException {
       // redisTemplate.getConnectionFactory().getConnection().flushDb();
        //真实的开发一般都是用json来传递对象
        User user = new User("qinxiaojin",23);
        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",jsonUser);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
    @Test
    public void tttest(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SS");
        System.out.println(simpleDateFormat.format(new Date()));
    }

    public static void main(String[] args) {
        Map<String,Object> params = new HashMap<>();
        params.put("one","s");
        params.put("two","ss");
        System.out.println(params);
    }
}
