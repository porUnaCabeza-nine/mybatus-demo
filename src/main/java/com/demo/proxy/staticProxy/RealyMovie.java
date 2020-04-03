package com.demo.proxy.staticProxy;

//真正实现播放电影的接口
public class RealyMovie implements Movie{
    @Override
    public void play() {
        System.out.println("正在播放《肖申克的救赎》");
    }
}
