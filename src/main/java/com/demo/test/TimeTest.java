package com.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: ljc
 * @createDate: 2019/11/21 14:35
 */
public class TimeTest {


    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmm");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yy-MM-dd HH:mm");
        try {
           Date date= sdf.parse("1911211436");
           System.out.println(date);
            System.out.println(sdf.format(date));
            System.out.println(sdf3.format(date));

            StringBuilder sb = new StringBuilder("20191121144725");
            sb.insert(8, 0);
            String s  = sb.toString();
            System.out.println("s:"+s);
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
            Date ds = sdf.parse(s);
            System.out.println(sdf.parse(s));
            System.out.println("日期:"+sdf2.format(
                    ds
            ));



        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
