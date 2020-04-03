package com.demo.hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        System.out.println("map demo test start!");
        Map<String,String> map = new HashMap();

        map.put("first","first-Value");
        map.put("second","second-Value");
        map.put("three","three-Value");


        // 遍历方法一 hashmap entrySet() 遍历
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key=" + key + " value=" + value);
        }
        System.out.println("---------------------------分割1--------------------------------");

        // 遍历方法二 hashmap keySet() 遍历
        for (Iterator i = map.keySet().iterator(); i.hasNext();) {
            Object obj = i.next();
            System.out.println("key为:"+obj);// 循环输出key
            System.out.println("key=" + obj + " value=" + map.get(obj));
        }
        //通过Map.values()遍历所有的value，但不能遍历key
        for (Iterator i = map.values().iterator(); i.hasNext();) {
            Object obj = i.next();
            System.out.println("直接输出value:"+obj);// 循环输出value
        }
        System.out.println("---------------------------分割2--------------------------------");

        // 遍历方法三 map keySet()遍历 普遍使用 二次取值
        for (Object o : map.keySet()) {
            System.out.println("key=" + o + " value=" + map.get(o));
        }


        map.remove("three");

        System.out.println("---------------------------分割3--------------------------------");
        //entrySet的方式进行遍历是效率最高的
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

    }

}
