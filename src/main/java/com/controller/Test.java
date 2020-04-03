package com.controller;

import com.entity.User;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Test {
    public static void main(String[] s){
        String zhangsan, lisi;
        zhangsan = new String("我是对象张三");
        lisi = new String("我是对象李四");
        zhangsan = lisi;
        System.out.println(zhangsan==lisi);

        int a = 3;
        int b = 3;

        a = 4;
        System.out.println("此时a的值："+a+";b的值:"+b);

//        long startTime=System.currentTimeMillis();   //获取开始时间
//        List<String> list = new LinkedList<String>();
//        for(int i =1;i<=1000000;i++){
//            list.add(generateShortUuid());
//        }
//        System.out.println("去重前长度"+list.size());
//        list = new LinkedList(new HashSet<String>(list));
//        System.out.println("去重后长度"+list.size());
//        long endTime=System.currentTimeMillis(); //获取结束时间
//        System.out.println("LinkedList程序运行时间： "+(endTime-startTime)+"ms");
    }


    //数字+小写字母
    public static String[] chars = new String[] {
            "0", "1", "2", "3", "4", "5","6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f","g", "h", "i", "j",
            "0", "1", "2", "3", "4", "5","6", "7", "8", "9",
            "k", "l", "m", "n", "o", "p", "q", "r", "s","t",
            "0", "1", "2", "3", "4", "5","6", "7", "8", "9",
            "u", "v", "w", "x", "y", "z", "7", "8", "9","0",
            "0", "1", "2", "3", "4", "5","6", "7", "8", "9",
            "0", "1", "2", "3", "4", "5","6", "7", "8", "9"
    };


    //生成短8位UUID
    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }

}
