package com.demo.html2Image.phontomjs_img.phontomjs;

/**
 * @description:
 * @author: ljc
 * @createDate: 2019/10/28 15:37
 */
public class MainTest {
    public static void main(String[] args) {
        String url = "http://www.baidu.com";
//        String url = "https://news.163.com/"; //网易新闻
//        String url ="http://39.98.89.166:9380/dzzp/images/20191028/b282a6cbf0a64f528777f89672b46781.png";
//        String jsPath =   System.getProperty("user.dir") + "/configFile/baidu.js";   //截取全屏 一直到滚动条底部
//        String jsPath =   System.getProperty("user.dir") + "/configFile/rasterize.js";   //截取div
        String jsPath = "D:\\AllSummaryFiles\\test/baidu.js";
        String imgpath = "/zp1baidu1111.png";
        //String jsPath = System.getProperty("user.dir") + "\\target\\js\\baidu.js"; //windows
        String cmdPath = "D:\\AllSummaryFiles\\test\\phantomjs-2.1.1-windows\\bin/phantomjs.exe";
        Screenshot.screenshot(cmdPath,url, imgpath, jsPath, "");
    }
}
