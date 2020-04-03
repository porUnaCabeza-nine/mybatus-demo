package com.demo.aboutThread.timingThread;

//线程类
public class TimingThread extends Thread {


        public void run() {
            while(true){
                try {
                    sleep(1000);
                    //这里可以写你自己要运行的逻辑代码
                    System.out.println("一s钟运行一次");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }


}
