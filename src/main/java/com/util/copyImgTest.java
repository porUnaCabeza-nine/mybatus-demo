package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class copyImgTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //复制的文件路径
        File fromFile = new File("F:/test1/1.png");
        //复制后的文件路径及文件名称
        File toFile = new File("F:/test1/test1/2.png");
        InputStream is = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            is = new FileInputStream(fromFile);
            os = new FileOutputStream(toFile);
            // 创建缓冲流
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);
            byte[]buffer = new byte[8192];
            int count = bis.read(buffer);
            while(count != -1){
                //使用缓冲流写数据
                bos.write(buffer,0,count);
                //刷新
                bos.flush();
                count = bis.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("视频复制完成,耗时:" + (endTime - startTime) + "毫秒");

    }

}


