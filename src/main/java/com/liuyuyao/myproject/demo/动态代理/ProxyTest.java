package com.liuyuyao.myproject.demo.动态代理;

import org.aopalliance.intercept.Invocation;

import java.lang.reflect.*;

/**
 * @author ：lyy
 * @date ：Created in 2021/7/21 11:09 下午
 * @description：
 */
public class ProxyTest {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Calculator calculator = new CalculatorImpl();
        Calculator calculatorProxy = (Calculator) getProxy(calculator);
        int add = calculatorProxy.add(1, 2);
        int minus = calculatorProxy.minus(1, 2);
        System.out.println(add);
        System.out.println(minus);
    }

    private static Object getProxy(Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Object proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
//                    @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            System.out.println("before proxy");
//            Object res = method.invoke(obj, args);
//            System.out.println("after proxy");
//            return res;
//        }
//    });
//        return proxy;
        Class clazz = Proxy.getProxyClass(obj.getClass().getClassLoader(), obj.getClass().getInterfaces());
        Constructor constructor = clazz.getConstructor(InvocationHandler.class);
        Object target = constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before proxy");
                Object res = method.invoke(obj, args);
                System.out.println("after proxy");
                return res;
            }
        });
        return target;
    }
}
