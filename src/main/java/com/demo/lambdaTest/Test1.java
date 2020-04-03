package com.demo.lambdaTest;

import com.alibaba.druid.sql.ast.expr.SQLCaseExpr;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ljc
 * @createDate: 2019/11/12 17:10
 */
public class Test1 {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("123");
        list1.add("456");
        list1.add("789");
        List<String> list2 = new ArrayList<>();
        list2.add("456s");
        list2.add("123");
        //从两个list集合中获取到相同的值
        List<String> s =list1.stream().filter(item-> list2.contains(item)).collect(Collectors.toList());
        System.out.println(s);

    }

}
