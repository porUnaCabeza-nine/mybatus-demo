package com.demo.getWindows;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetWindwosInfo {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();   //获取开始时间
        OperatingSystemMXBean osmx = (OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
        System.out.println("**********"+new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date())+"**********");
        List list = new ArrayList();
        list.add("系统内存:"+osmx.getTotalPhysicalMemorySize()/1024/1024+"m");
        list.add("剩余内存:"+osmx.getFreePhysicalMemorySize()/1024/1024+"m");
        list.add("内存使用率:"+(1-osmx.getFreePhysicalMemorySize()*1.0/osmx.getTotalPhysicalMemorySize())*100+"%");
        list.add("操作系统:"+System.getProperty("os.name"));
        list.add("系统架构:"+ System.getProperty("os.arch"));
        list.add("系统版本:"+System.getProperty("os.version"));
        list.add("系统语言:"+System.getProperty("user.language"));
        list.add("当前操作系统的用户名称:"+System.getProperty("user.name"));
        list.add("CPU负载:"+osmx.getSystemCpuLoad()*100+"%");
        list.add("系统时区:"+System.getProperty("user.timezone"));
        list.add("当前工程的工作目录:"+System.getProperty("user.dir"));
        list.add("CPU核数："+osmx.getAvailableProcessors());
        list.add("JVM信息:"+System.getProperty("java.vm.name"));
        list.add("JVM版本:"+ System.getProperty("java.version"));
        list.add("JAVA_HOME信息:"+System.getProperty("java.home"));
        list.add("JVM占用内存:"+Runtime.getRuntime().totalMemory()/1024/1024+"m");
        list.add("JVM空闲内存:"+Runtime.getRuntime().freeMemory()/1024/1024+"m");
        list.add("JVM最大内存:"+Runtime.getRuntime().maxMemory()/1024/1024+"m");

        for (int i =0;i<list.size();i++) {
            System.out.println(list.get(i));
        }

        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
