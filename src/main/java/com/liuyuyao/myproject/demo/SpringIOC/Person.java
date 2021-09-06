package com.liuyuyao.myproject.demo.SpringIOC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ：lyy
 * @date ：Created in 2021/8/5 4:46 下午
 * @description：
 */
@Component
public class Person {

//    @Qualifier("bmw")
//    @Autowired
    private Car car;

    private Shoes shoes;

//    public Person(Car car, Shoes shoes) {
//        this.car = car;
//        this.shoes = shoes;
//    }
//
//    @Autowired
    public Person(Car car) {
        this.car = car;
        System.out.println("breakpoint");
    }




    // setter方法。在@Bean场景下，手动调用setter方法设置成员变量
    public void setCar(Car car) {
        this.car = car;
        System.out.println("breakpoint");
    }

    @Override
    public String toString() {
        return "Person{" +
                "car=" + car +
                '}';
    }
}
