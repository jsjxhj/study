package com.owen.study.JDKDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类
 * Created by owen on 2017/6/13.
 */
public class CarServiceJDKDynamicProxy implements InvocationHandler {
    private CarService carServiceTarget;//被代理的目标类

    /**
     * 在构造函数中设置被代理的目标类
     * 也可以使用set方法设置被代理的目标类
     *
     * @param carServiceTarget
     */
    public CarServiceJDKDynamicProxy(CarService carServiceTarget) {
        this.carServiceTarget = carServiceTarget;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("before excute target object...");
        Object object = method.invoke(this.carServiceTarget, args);
        System.out.println("after excute target object...");
        return object;
    }
}
