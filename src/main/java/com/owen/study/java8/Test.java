package com.owen.study.java8;

import java.math.BigDecimal;

/**
 * Created by owen on 2016/12/24.
 */
public class Test {
    public static void main(String[] args){
        long size = 11;
        BigDecimal bd = new BigDecimal(size).divide(BigDecimal.valueOf(1000), 2, BigDecimal.ROUND_UP);
        System.out.print(bd.doubleValue());
        int x = 4;
        int y = 5;
        if(x++>4 & ++y>5) {
            x++;
        }
        System.out.println("x=" + x + ",y=" + y);
    }
}
