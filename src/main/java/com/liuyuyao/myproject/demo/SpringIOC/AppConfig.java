package com.liuyuyao.myproject.demo.SpringIOC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author ：lyy
 * @date ：Created in 2021/8/5 4:44 下午
 * @description：
 */
@Configuration
@ComponentScan
public class AppConfig {
//    @Qualifier("bmw")
//    @Autowired
//    Car benz;

//    //new一个Benz对象，通过@Bean注解告知Spring把这个bean加到容器
//    @Bean
//    public Car benz(){
//        return new Benz();
//    }
//
//    //new一个Bmw对象，通过@Bean注解告知Spring把这个bean加到容器
//    @Bean
//    public Car bmw(){
//        return new Bmw();
//    }

    //new一个Person对象，通过@Bean注解告知Spring把这个bean加到容器
//    @Bean
//    public Person person(){
//        Person p = new Person();
//        p.setCar(benz);
//        Car car = new Benz();
//        return p;
//    }

}
