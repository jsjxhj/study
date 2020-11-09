package com.owen.study.dynamic.instrumentation;

/**
 * @author Owen Xu
 * @date 2019/11/27 8:59
 */
public class Sample {
    public static void main(String[] args) {
        helloWorld();
    }

    private static void helloWorld() {
        System.out.printf("Hello World!");
    }
}
