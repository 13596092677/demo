package com.liuyuyao.myproject.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : mi
 * create at:  2021/3/19  下午4:58
 * @description: Spring Boot
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "Hello Spring Boot";
    }
}

//第二次提交
//第三次提交