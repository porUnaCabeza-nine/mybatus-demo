package com.demo.proxy.staticProxy;

//代理类，虽然重写了父接口的方法，但并没有具体的实现，
public class Cinema implements Movie{

    RealyMovie realyMovie ;
    //代理类的构造 引用具体的实现类
    public Cinema(RealyMovie realyMovie){
        this.realyMovie=realyMovie;
    }
    @Override
    public void play() {
        System.out.println("*****************代理类开始做一些事情了********************");
        guanggao(true);
        System.out.println("*****************代理类事情做完了，调用具体的实现类实现父类的接口********************");
        realyMovie.play();
        System.out.println("***********具体实现类完成了父接口的事情后，代理类又开始做它的事情了********************");
        guanggao(false);
    }
    private void guanggao(boolean isStart){
        if ( isStart ) {
            System.out.println("电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！");
        } else {
            System.out.println("电影马上结束了，爆米花、可乐、口香糖9.8折，买回家吃吧！");
        }
    }

}
