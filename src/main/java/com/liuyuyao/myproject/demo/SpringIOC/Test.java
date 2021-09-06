package com.liuyuyao.myproject.demo.SpringIOC;

import com.liuyuyao.myproject.demo.DemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author ：lyy
 * @date ：Created in 2021/8/5 4:46 下午
 * @description：
 */
@SpringBootApplication
public class Test {
    public static void main(String[] args) {
        // AnnotationConfigApplicationContext是Spring用来专门针对注解开发的ApplicationContext子类
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 从容器中获取Person
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
//        String[] beans = applicationContext.getBeanDefinitionNames();
//        Arrays.sort(beans);
//        for (String bean : beans)
//        {
//            System.out.println(applicationContext.getBean(bean).getClass());
//        }
    }
}
