package com.demo.proxy.dynamicProxy;

//卖的茅台酒
public class MaoTai implements SellWine {
    @Override
    public void maijiu() {
        System.out.println("我这里卖的是国酒茅台");
    }
}
