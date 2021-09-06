package com.liuyuyao.myproject.demo.动态代理;

/**
 * @author ：lyy
 * @date ：Created in 2021/7/22 11:25 下午
 * @description：
 */
public @interface MyAnnotation {
    public final int i = 1;

    String getValue() default "no description";
}
