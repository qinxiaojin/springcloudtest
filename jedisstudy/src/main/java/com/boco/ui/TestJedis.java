package com.boco.ui;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestJedis {
    public static void main(String[] args) {
        /**连接redis**/
        Jedis jedis = new Jedis("192.168.1.4",6379);
        System.out.println(jedis.ping());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","qinxiaojin");
        //开启事务
        Transaction multi = jedis.multi();
        String result = jsonObject.toJSONString();
        System.out.println("result:"+result);
        try{
            multi.set("user1",result);
            multi.set("user2",result);

            multi.exec();
        }catch(Exception e){
            multi.discard();
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }
    }
}
