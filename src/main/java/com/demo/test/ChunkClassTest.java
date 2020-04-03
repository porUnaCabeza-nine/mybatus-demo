package com.demo.test;

import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChunkClassTest {

    public static void main(String[] args) {

//         <img src="res/images/avatar/0.jpg" />

        List<ChunkClassDemo> list = new ArrayList<>();
        for (int i =0;i<=35;i++) {
            ChunkClassDemo chunk = new ChunkClassDemo();
//            chunk.setChunkName("桌牌模板名称"+i);
            chunk.setId(i+1);
            chunk.setImgUrl("res/images/avatar/0.jpg");
            chunk.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
            chunk.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
            list.add(chunk);
        }
        System.out.println(JSON.toJSONString(list));

        String s = "";

        System.out.println("s:"+s.length());

    }
}
