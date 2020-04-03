package com.demo.ClassAbout;

/**
 * @description:
 * @author: ljc
 * @createDate: 2019/12/25 10:16
 */
public class ClassB {

    static {
        ClassA t2;
        System.out.println("C");
    }
    public static void main(String[] args) {
        Class c1;
        Class c2;
        Class c3;
        try {
            c1 = ClassA.class;
            c2 = Class.forName("com.demo.ClassAbout.ClassA");
            ClassA a = new ClassA();
            c3 = a.getClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        if (c2 == c1&& c1 == c3) {
            System.out.println("D");
        } else {
            System.out.println("E");
        }
        System.out.println(ClassA.count);
    }
}
