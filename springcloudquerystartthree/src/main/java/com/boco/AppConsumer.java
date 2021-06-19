package com.boco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient //当前使用eureka server
public class AppConsumer
{
    public static void main( String[] args )
    {
        SpringApplication.run(AppConsumer.class,args);
    }
}
