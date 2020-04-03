package com.demo.test.listTest;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.BinaryClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ljc
 * @createDate: 2019/11/26 11:26
 */
public class TestTsmsCout {

    public static void main(String[] args) {

        List<TsmsCount> list = new ArrayList<>();
        for (int i =0;i<10;i++) {
            TsmsCount t = new TsmsCount();
            t.setTaskId(i+1);
            t.setCm("cm");
            t.setDelivrds(33254+i);
            t.setMobiles(36984+i);
            t.setSmss(32112+i);
            t.setSubmits(35698+i);
            if (i==0) {
                t.setSendday(20191125);
            }else if (i==3){
                t.setSendday(20191126);
            }else {
                t.setSendday(20191127);
            }
            list.add(t);
        }
        System.out.println("数据:"+ JSON.toJSONString(list));

        Map<TsmsCount, TsmsCount> map = new HashMap<TsmsCount, TsmsCount>();
        for (TsmsCount s : list) {
            if (map.containsKey(s)) {
                map.put(s, TsmsCount.merge(s, map.get(s)));
            } else {
                map.put(s, s);
            }
        }
        System.out.println("数据2："+JSON.toJSONString(map));


    }

}
