package com.demo.collercionsDemo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @description:
 * @author: ljc
 * @createDate: 2020-03-18 17:15
 */
public class CollectionsDemoTest {
    public static void main(String[] args) {
        List<SysMenu> list = new ArrayList<>();
        for (int i=0;i<6;i++) {
            int number = new Random().nextInt(5);
            SysMenu sys = new SysMenu();
            sys.setName("name"+number);
            sys.setOrderNum(number);
            list.add(sys);
        }
        System.out.println("未排序前：");
        for (SysMenu m:list) {
            System.out.println(m.toString());
        }
//        开始排序
        Collections.sort(list, (o1, o2) -> {
            if (o1.getOrderNum() == null && o2.getOrderNum() == null) {
                return 0;
            }
            if (o1.getOrderNum() == null  ) {
                return 1;
            }
            if (o2.getOrderNum() == null  ) {
                return -1;
            }
            if (o1.getOrderNum() > o2.getOrderNum()) {
                return 1;
            }
            if (o1.getOrderNum().equals(o2.getOrderNum())) {
                return 0;
            }
            return -1;
        });
        System.out.println("排序后:");
        for (SysMenu m:list) {
            System.out.println(m.toString());
        }
    }
}



