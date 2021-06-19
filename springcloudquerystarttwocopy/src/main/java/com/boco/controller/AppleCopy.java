package com.boco.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")
public class AppleCopy {
    @RequestMapping("/World")
    public String helloApple(String s){
        System.out.println("传入的值copy："+s);
        return "传入的值copy："+s;
    }
}
