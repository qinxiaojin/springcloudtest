package com.boco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Hello")
public class Consumption {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/Consumer")
    public String helloWorld(String s){
        System.out.println("传入的值："+s);
        //第一种调用方式
//        String forObject = new RestTemplate()
//                .getForObject("http://localhost:8701/Hello/World?s="+s,String.class);
        /**
        //第二种调用方式
        //根据服务名，获取服务列表 根据算法选取莫个服务
        //并访问莫个服务的网络位置
        //ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKA-SERVICE");
        String forObject = new  RestTemplate()
               .getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance
               .getPort()+"/Hello/World?s="+s,String.class);
         */
        //第三种调用方式 需要restTemplate注入的方式
        String forObject = restTemplate.getForObject("" +
                "http://EUREKA-SERVICE/Hello/World?s="+s,String.class);
        return forObject;
    }
    @RequestMapping("/apple")
    public String helloApple(String s){
        //第二种调用方式
        //根据服务名，获取服务列表 根据算法选取莫个服务
        //并访问莫个服务的网络位置
        ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKA-SERVICECOPY");
        String forObject = new  RestTemplate()
                .getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance
                        .getPort()+"/Hello/World?s="+s,String.class);
        return forObject;
    }
}
