package com.owen.study.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获取类对象的相关信息工具类
 *
 * @Author Owen Xu
 * @Date 2018/11/19
 */
public class ClassUtil {
    /**
     * 打印类的信息，成员变量，方法
     *
     * @param object
     */
    public static void printClassInfo(Object object) {

        Class clazz = object.getClass();
        System.out.println("class name: " + clazz.getName());

        /**
         * Method类，方法对象
         * 一个成员方法就是一个Method对象
         * getMethods()方法获取所有的public的方法，包括父类继承而来的
         * getDeclaredMethods()获取所有该类自己声明的方法，所有访问权限
         */
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            //获取返回值类型类
            Class returnType = methods[i].getReturnType();
            System.out.print(returnType.getName() + " ");

            //获取方法名称
            System.out.print(methods[i].getName() + "(");

            //获取方法参数列席列表
            Class[] paramTypes = methods[i].getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName() + ",");
            }

            System.out.println(")");
        }

        /**
         * Field 成员变量，封装了成员变量的操作
         * clazz.getFields() 获取所有的public的成员变量信息
         * clazz.getDeclaredFields() 获取该类自己声明的所有成员变量信息
         */
        //Field[] fields = clazz.getFields();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            String fieldName = field.getName();
            System.out.println(typeName + " " + fieldName);
        }

    }
}
