package com.demo.test;

import com.entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BeanTest {

    public static void main(String[] s) throws ParseException {
//        User u = new User();
//        User uu = new User();
//        uu.setAddress("wh");
//        uu.setUserName("ssss");
//        System.out.println(u);
//        System.out.println(uu);
//        boolean flat = false;
//        if(flat){
//            System.out.println("打印："+flat);
//        }else{
//            System.out.println("打印2222："+flat);
//        }

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date expiryDate=sdf.parse("2019-07-03 18:00:00");
        Date nowDate=new Date();
        if (expiryDate.before(nowDate)){
            System.out.println("expiryDate时间小于当前时间,超时了");
        }else{
            System.out.println("expiryDate大于当前日期nowDate ,没超时:");
        }

        if (expiryDate.after(nowDate)) {

            System.out.println("expiryDate时间在当前日期之后");
        }else {
            System.out.println("expiryDate时间在当前日期之前");
        }
        System.out.println("时间转换:"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

    }

}
