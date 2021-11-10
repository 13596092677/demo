package com.liuyuyao.myproject.demo.entends_super;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/11/10 11:18 上午
 * @description：
 */
public class demo {
    public static void main(String[] args) {
        /**
         * true
         * super操作 可存不可取
         */
//        List<? super Apple> list = new ArrayList<>();
//        list.add(new BigApple());
//        list.add(new Apple());
        /**
         * false
         * extends操作 可取不可存
         */
//        List<? extends Apple> list = new ArrayList<>();
//        list.add(new Apple());
        /**
         * true
         */
//        List<Fruit> fruitList = new ArrayList<>();
//        List<Apple> appleList = new ArrayList<>();
//        fruitList.addAll(appleList);
    }
}
