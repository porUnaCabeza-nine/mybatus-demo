package com.demo.proxy.staticProxy;

public class TestStaticProxy {
    public static void main(String[] s){
        //具体实现类的对象。
        RealyMovie realyMovie = new RealyMovie();
        //接口指向代理类（代理类引用具体的实现类，此为静态代理模式）
        Movie movie = new Cinema(realyMovie);
        //代理类里
        movie.play();
    }

}
