package com.demo.html2Image.phontomjs_img.phontomjs;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @description: 利用phantomjs截取网页工具类。
 * @author: ljc
 * @createDate: 2019/10/28 15:28
 */
public class Screenshot {
    //phantomjs程序位置
//    private static final String cmdPath = System.getProperty("user.dir") + "\\configFile\\phantomjs.exe";   //windows

    //绝对路径
//    private static final String cmdPath = "D:\\AllSummaryFiles\\test\\phantomjs-2.1.1-windows\\bin/phantomjs.exe";

//    private static final String cmdPath =	System.getProperty("user.dir") + "/phantomjs";    //linux

    // imgpath   /img/2222.png
    public static void screenshot(String cmdPath,String url, String imgpath, String jsPath) {
        screenshot(cmdPath,url, imgpath,jsPath, "");
    }

    /**
     * @Description //TODO
     * @Author ljc
     * @Date  2019/10/30 13:36
     * @Param  url : 需要截图的地址 如：http://www.baidu.com
     *         imgpath 截图后保存的后缀 "/zp.png"
     *         jsPath  截图需要用到的Js
     *         title 可以为空
     * @return
     **/
    public static void screenshot(String cmdPath,String url, String imgpath, String jsPath,String title) {
        BufferedReader reader = null;
        InputStream inputStream = null;
        try {
            System.out.println("start......"+url);
            String[] cmd = new String[] { cmdPath, jsPath, url, getPicSavePath(imgpath), title };
//            for (String string : cmd) {
//                System.out.println("数组里的内容:"+string);
//            }
            System.out.println("数组里的内容:"+ JSON.toJSONString(cmd));
            Process process = Runtime.getRuntime().exec(cmd);
            inputStream = process.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sbf = new StringBuffer();
            String tmp = " ";
            while ((tmp = reader.readLine()) != null) {
                sbf.append(tmp);
            }
            System.out.println("图片存放D:AllSummaryFiles目录");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return true;
    }

    private static String getPicSavePath(String imgpath) {
        return "D:\\AllSummaryFiles" + imgpath;
    }

}
