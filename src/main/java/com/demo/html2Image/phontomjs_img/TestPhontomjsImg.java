package com.demo.html2Image.phontomjs_img;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Description //利用phantomjs截图demo phantomjs官网下载地址：https://phantomjs.org/download.html
 * @Author ljc
 * @Date  2019/10/28 15:26
 * @Param
 * @return
 **/
public class TestPhontomjsImg {
    public static void main(String[] args) throws IOException {
        System.out.println("当前项目路径地址:"+System.getProperty("user.dir"));
        String BLANK = "  ";
        Process process = Runtime.getRuntime().exec("D:\\AllSummaryFiles\\test\\phantomjs-2.1.1-windows\\bin/phantomjs.exe" + BLANK
                        + "D:\\AllSummaryFiles\\test\\phantomjs-2.1.1-windows\\examples/rasterize.js" + BLANK
                        + "http://www.baidu.com" + BLANK
                        + "D:\\AllSummaryFiles\\screenshorts\\newFile1234.png");

        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        String tmp = "";
//        while ((tmp = reader.readLine()) != null) {
//            if (reader != null) {
//                reader.close();
//            }
//            if (process != null) {
//                process.destroy();
//                process = null;
//            }
//            System.out.println("渲染成功...");
//        }
    }

}
