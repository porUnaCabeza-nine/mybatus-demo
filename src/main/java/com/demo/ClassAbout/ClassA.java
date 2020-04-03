package com.demo.ClassAbout;

/**
 * @description:
 * @author: ljc
 * @createDate: 2019/12/25 10:16
 */
public class ClassA {
    static int count = 0;
    static {
        count++;
        System.out.println("A");
    }
    public ClassA() {
        System.out.println("B");
    }
}

