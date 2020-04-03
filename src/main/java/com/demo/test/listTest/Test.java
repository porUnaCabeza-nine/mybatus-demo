package com.demo.test.listTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test {

    public static void main(String[] args) {
        List<S> list = new ArrayList<S> ();
        list.add(new S("小刘" ,   "2015/9/1",   2));
        list.add(new S("小刘" ,   "2015/9/2",   3));
        list.add(new S("小强" ,   "2015/9/1",   4));
        list.add(new S("小强" ,   "2015/9/1",   5));
        list.add(new S("小刘" ,   "2015/9/1",   6));
        list.add(new S("小图" ,   "2015/9/1",   7));
        list.add(new S("小刘" ,   "2015/9/1",   8));
        list.add(new S("小图" ,   "2015/9/1",   9));
        list.add(new S("小刘" ,   "2015/9/2",   99));
        Map<S, S> map = new HashMap<S, S> ();
        for (S s : list) {
            if (map.containsKey(s)) {
                map.put(s, S.merge(s, map.get(s)));
            } else {
                map.put(s, s);
            }
        }
        System.out.println(map.values());
    }

}
