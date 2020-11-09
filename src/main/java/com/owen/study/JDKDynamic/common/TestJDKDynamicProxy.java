package com.owen.study.JDKDynamic.common;

import com.owen.study.JDKDynamic.CarService;
import com.owen.study.JDKDynamic.CarServiceImpl;
import com.owen.study.JDKDynamic.CarServiceJDKDynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Created by owen on 2017/6/13.
 */
public class TestJDKDynamicProxy {
    /**
     * JDK中动态代理技术中的代理调用
     *
     * @param args
     */
    public static void main(String[] args) {
        CarService carServiceTarget = new CarServiceImpl();
        JDKDynamicProxy jDKDynamicProxy = new JDKDynamicProxy(carServiceTarget);
        CarService carServiceProxy = (CarService) Proxy.newProxyInstance(carServiceTarget.getClass().getClassLoader(),
                new Class[]{CarService.class}, jDKDynamicProxy);
        //执行代理类的方法
        //作用一：间接执行被代理类的方法，
        //作用二：代理类可以在被代理类方法执行前后做一些额外操作
        //总结：不更改原有类的功能和程序代码情况下，实现额外的功能能
        //缺点：要为每个被代理类编写一个代理类，且具有相同的接口
        carServiceProxy.start();
        carServiceProxy.getLoadAmount();
        String driver = carServiceProxy.setDriver("fruitking");
        System.out.println(driver);
    }
}
