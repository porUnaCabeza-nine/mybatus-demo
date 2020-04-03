package com.demo.ClassAbout;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: ljc
 * @createDate: 2019/12/25 14:09
 */
public class TestMain {
    public static void main(String[] args) {
        Integer i = new Integer(50);

        String str = "成都市(成华区)(武侯区)(高新区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }

        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        map.put("test1","test");
        map.put("test2","test2");
        System.out.println(map.toString());

    }
}
