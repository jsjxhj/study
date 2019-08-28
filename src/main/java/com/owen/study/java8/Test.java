package com.owen.study.java8;

import java.util.Locale;

/**
 * Created by owen on 2016/12/24.
 */
public class Test {
    public static void main(String[] args){
        String fileName = "HC2017003D-PCT International Search Report 【PCTISA210】.pdf";
        String lowerCase = fileName.toLowerCase(Locale.getDefault());
        System.out.printf(lowerCase);
    }
}
