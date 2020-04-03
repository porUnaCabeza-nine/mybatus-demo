package com.demo.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {
    public static void main(String[] s) throws InterruptedException {
        MaoTai maotaijiu = new MaoTai();//茅台
        WuLiangYe wu = new WuLiangYe();//五粮液
        XiaoSu su = new XiaoSu();// 苏烟
        InvocationHandler jingxiao1 = new GuiTaI(maotaijiu);
        InvocationHandler jingxiao2 = new GuiTaI(wu);
        InvocationHandler jingxiao3 = new GuiTaI(su);
        //动态代码涉及了一个非常重要的类 Proxy。正是通过 Proxy 的
        // 静态方法 newProxyInstance 才会动态创建代理。
        SellWine dynamicProxy = (SellWine) Proxy.newProxyInstance(MaoTai.class.getClassLoader(),
                MaoTai.class.getInterfaces(), jingxiao1); //进销1卖茅台
        SellWine dynamicProxy2 = (SellWine) Proxy.newProxyInstance(WuLiangYe.class.getClassLoader(),
                WuLiangYe.class.getInterfaces(), jingxiao2);//进销2卖五粮液
        SellCigarette dynamicProxy3 = (SellCigarette) Proxy.newProxyInstance(XiaoSu.class.getClassLoader(),
                XiaoSu.class.getInterfaces(), jingxiao3);//进销2卖五粮液
        dynamicProxy.maijiu();
        System.out.println("稍等几秒，我去拿货");
        Thread.sleep(3000);
        dynamicProxy2.maijiu();
        System.out.println("稍等几秒，我去拿烟");
        Thread.sleep(3000);
        dynamicProxy3.sellSmoke();
        System.out.println("dynamicProxy class name:"+dynamicProxy.getClass().getName());
        System.out.println("dynamicProxy1 class name:"+dynamicProxy2.getClass().getName());
        System.out.println("dynamicProxy3 class name:"+dynamicProxy3.getClass().getName());

    }

}
