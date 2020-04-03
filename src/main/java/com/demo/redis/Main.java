package com.demo.redis;

import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class Main {
    /*
    * pom引入的版本
    * <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-pool2</artifactId>
            <version>2.4.2</version>
        </dependency>
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
            <version>2.9.0</version>
            <type>jar</type>
            <scope>compile</scope>
        </dependency>
    * */
    public static void main(String[] s){
        RedisCacheStorageImpl redisCacheStorage = new RedisCacheStorageImpl();
        System.out.println("开始执行测试");
        User user=new User();
        user.setUserName("admin7");
        user.setAddress("这斯一个地址");

        redisCacheStorage.set("Akey7",user);
        String user2= redisCacheStorage.get("Akey7",new User());
        System.out.print("通过key，取出来的值:"+user2);
    }



}
