package com.liuyuyao.myproject.demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : mi
 * create at:  2021/3/22  下午5:05
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElkApplicationTest {
    @Value("${profile.name}")
    private String name;

    private Logger logger = LogManager.getLogger(SpringbootElkApplicationTest.class);

    @Test
    public void contextLoads() {
    }



    @Test
    public void test() throws Exception {

        System.out.println(name);

    }



}
