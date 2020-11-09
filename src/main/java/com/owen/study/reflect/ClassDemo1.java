package com.owen.study.reflect;

import java.io.Serializable;

/**
 * java.lang.Class 类的使用
 * @Author Owen Xu
 * @Date 2018/11/19
 */
public class ClassDemo1 {
    public static void main(String[] args) {
        Foo foo1 = new Foo();

        //任何一个类都有一个Class的实例对象,有三种表示方式
        //1. 任何一个类都有一个隐含的静态成员变量class
        Class clazz1 = Foo.class;

        //2. 通过对象的getClass()方法获取
        Class clazz2 = foo1.getClass();

        System.out.println("(clazz1 == clazz2) = " + (clazz1 == clazz2));

        //3. 通过Class.forName方法获取
        try {
            //动态加载类，编译时候Foo类可以不存在
            Class clazz3 = Class.forName("com.owen.study.reflect.Foo");
            System.out.println("(clazz1 == clazz3) = " + (clazz1 == clazz3));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * clazz1, clazz2, clazz3都是Foo类的类型，一个类只能有一个类类型,所以都是相等的
         */

        //通过类的类型创建该类的实例
        try {
            Foo foo = (Foo)clazz1.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Foo implements Serializable {}
