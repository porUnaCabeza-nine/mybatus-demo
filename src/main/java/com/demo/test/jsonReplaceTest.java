package com.demo.test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jsonReplaceTest {

    public static void main(String[] args) throws JSONException {
        String json="{\"id\":\"10001\",\"name\":\"肉类\",\"menus\":[{\"name\":\"牛肉\",\"price\":\"30.00\"},{\"name\":\"羊肉\",\"price\":\"20.00\"}]}";
        System.out.println("1. "+json);
        JSONObject kindJson=new JSONObject(json);//将string转为jsonobject
        String menuJson=kindJson.getString("menus");//获取到menus
        JSONArray menus=new JSONArray(menuJson);//再将menuJson转为jsonarray
        System.out.println("2. "+menus);
        JSONObject beefJson= menus.getJSONObject(0);//根据下标0（类似数组）获取牛肉的json对象
        beefJson.put("price", "50.00");//直接提交price的key，如果该key存在则替换value
        menus.put(0, beefJson);//覆盖掉原来的值

        System.out.println("3. "+beefJson);
        System.out.println("4. "+menus);//替换完后打印查看
        kindJson.put("menus", menus);//再将menus覆盖

        json=kindJson.toString();//赋值
        System.out.println("5. "+json);//替换完成
    }

}
