package com.liuyuyao.myproject.demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
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


    private Logger logger = LogManager.getLogger(SpringbootElkApplicationTest.class);

    @Test
    public void contextLoads() {
    }



    @Test
    public void test() throws Exception {

        for (int i = 0; i < 100; i++) {
            logger.info("输出info 123 ");
            logger.debug("输出debug+skkkw嗡嗡嗡kw 123");
            logger.error("输出error  嗡嗡嗡我 123");
        }
    }



}
