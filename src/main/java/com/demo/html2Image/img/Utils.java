package com.demo.html2Image.img;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;


public class Utils {
    /**
     * 图片转换成二进制字符串
     *
     * @param imageUrl
     *            图片url
     * @return String 二进制流
     */
    public static String getImgeHexStringByUrl(String imageUrl) {
        String res = null;
        try {
            int HttpResult = 0; // 服务器返回的状态
            URL url = new URL(imageUrl); // 创建URL
            URLConnection urlconn = url.openConnection(); // 试图连接并取得返回状态码
            urlconn.connect();
            HttpURLConnection httpconn = (HttpURLConnection) urlconn;
            HttpResult = httpconn.getResponseCode();
            if (HttpResult != HttpURLConnection.HTTP_OK) // 不等于HTTP_OK则连接不成功
                System.out.print("failed");
            else {
                BufferedInputStream bis = new BufferedInputStream(urlconn.getInputStream());
                BufferedImage bm = ImageIO.read(bis);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                String type = imageUrl.substring(imageUrl.length() - 3);
                ImageIO.write(bm, type, bos);
                bos.flush();
                byte[] data = bos.toByteArray();
                res = byte2hex(data);
                bos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 本地图片转换成二进制字符串
     *
     * @param imageUrl
     *            图片url
     * @return String 二进制流
     */
    public static String getImgeHexStringByLocalUrl(String imageUrl) {
        String res = null;

        try {
            File imageFile = new File(imageUrl);
            InputStream inStream = new FileInputStream(imageFile);
            BufferedInputStream bis = new BufferedInputStream(inStream);
            BufferedImage bm = ImageIO.read(bis);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            String type = imageUrl.substring(imageUrl.length() - 3);
            ImageIO.write(bm, type, bos);
            bos.flush();
            byte[] data = bos.toByteArray();
            res = byte2hex(data);
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * @title 根据二进制字符串生成图片
     * @param data
     *            生成图片的二进制字符串
     * @param fileName
     *            图片名称(完整路径)
     * @param type
     *            图片类型
     * @return
     */
    public static void saveImage(String data, String fileName, String type) {

        BufferedImage image = new BufferedImage(300, 300, BufferedImage.TYPE_BYTE_BINARY);
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, type, byteOutputStream);
            // byte[] date = byteOutputStream.toByteArray();
            byte[] bytes = hex2byte(data);
            RandomAccessFile file = new RandomAccessFile(fileName, "rw");
            file.write(bytes);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反格式化byte
     *
     * @param s
     * @return
     */
    public static byte[] hex2byte(String s) {
        byte[] src = s.toLowerCase().getBytes();
        byte[] ret = new byte[src.length / 2];
        for (int i = 0; i < src.length; i += 2) {
            byte hi = src[i];
            byte low = src[i + 1];
            hi = (byte) ((hi >= 'a' && hi <= 'f') ? 0x0a + (hi - 'a') : hi - '0');
            low = (byte) ((low >= 'a' && low <= 'f') ? 0x0a + (low - 'a') : low - '0');
            ret[i / 2] = (byte) (hi << 4 | low);
        }
        return ret;
    }

    /**
     * 格式化byte
     *
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] out = new char[b.length * 2];
        for (int i = 0; i < b.length; i++) {
            byte c = b[i];
            out[i * 2] = Digit[(c >>> 4) & 0X0F];
            out[i * 2 + 1] = Digit[c & 0X0F];
        }

        return new String(out);
    }

    public static void main(String[] args) {
        //本地图片
        String fileName = "E://fly.jpg";
        String url = "http://images.cnitblog.com/blog/536814/201412/051633343733092.png";
        String outImage = "E://11.jpg";
        /*
         * url形式
         * */
//        String result = getImgeHexStringByUrl(url);
//        System.out.println(result);
//        saveImage(result,fileName,"png");
        /*
         * 本地图片形式
         * */
        String result1 = getImgeHexStringByLocalUrl(fileName);
        System.out.println(result1);
        saveImage(result1,outImage,"jpg");
    }

}
