package com.liuyuyao.myproject.demo.动态代理;

import org.springframework.web.bind.annotation.*;

/**
 * @author ：lyy
 * @date ：Created in 2021/7/21 11:08 下午
 * @description：
 */
@MyAnnotation(getValue = "123")
@RequestMapping(method = RequestMethod.GET)
@ResponseBody
public class CalculatorImpl implements Calculator {
    @RequestMapping(path="123")
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}
