package com.demo.imgzhuanhuan;

import com.demo.html2Image.img.Base64Utils;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description:
 * @author: ljc
 * @createDate: 2020-03-31 15:22
 */
public class PngToBmp {

    public static void main(String[] args) {
        //图片转 base64
      String str=Base64Utils.ImageToBase64ByLocal("D://xxxx.png");
        System.out.println(str);
      String imgPath = "D://xxxBmp";
      base64ToImg(str,imgPath);
    }

    //base64 转图片 bmp格式
    public static void base64ToImg(String base64,String pngName){
        String imgBase64 = base64.replaceAll("data:image/png;base64,","");
        BASE64Decoder d = new BASE64Decoder();
        byte[] data = new byte[0];
        try {
//            System.out.println("打印字节流:"+base64.getBytes());

            data = d.decodeBuffer(imgBase64);
            FileOutputStream os = new FileOutputStream(pngName+".bmp");
            os.write(data);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("base64 转图片 bmp格式失败{}"+e);
        }
    }
}
