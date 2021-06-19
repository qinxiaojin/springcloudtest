package com.boco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient //代表自己是一个服务提供方
public class AppService
{
    public static void main( String[] args )
    {
        SpringApplication.run(AppService.class,args);
    }
}
