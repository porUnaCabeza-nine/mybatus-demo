package com.demo.proxy.dynamicProxy;

//拿到卖酒许可证
public class WuLiangYe implements SellWine {
    @Override
    public void maijiu() {
        System.out.println("这里卖的是五粮液!");
    }
}
