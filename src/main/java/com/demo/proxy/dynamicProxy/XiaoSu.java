package com.demo.proxy.dynamicProxy;

public class XiaoSu implements SellCigarette {
    @Override
    public void sellSmoke() {
        System.out.println("这里卖的烟是，苏烟！");
    }
}
