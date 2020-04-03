package com.demo.imgToBin;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImgToBin {
    public static void main(String[] args) {
        try {
            convertSingleColorBMPFile2("E://xxx.bmp","E://xxx.bin");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void convertSingleColorBMPFile2(String imgPath,String binPath) throws Exception {


        BufferedImage sourceImg_ys = ImageIO.read(new File(imgPath));

        //顺时针旋转270度
        BufferedImage sourceImg = RotateImage.Rotate(sourceImg_ys, 270);
        ImageIO.write(sourceImg, "bmp", new File("D:/1234.bmp"));
        int h = sourceImg.getHeight();
        int w = sourceImg.getWidth();

        int[] pixels = new int[w * h];
        List<String> pixel_arr = new ArrayList<>();
        List<String> pixel_arr_rw = new ArrayList<>();
        byte[]  bytes = new byte[w * h/4];
        PixelGrabber pixelGrabber = new PixelGrabber(sourceImg, 0, 0, w, h, pixels, 0, w);
        pixelGrabber.grabPixels();

        System.out.println("原图宽：" + w + "高：" + h);
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                int color = pixels[w * row + col];
                int r = (color & 0x00FF0000) >> 16;
                int g = (color & 0x0000FF00) >> 8;
                int b = color & 0x000000FF;

                int gapg = Math.abs(r - g);
                int gapb = Math.abs(r - b);

                if (gapg < 20 && gapb < 20 && r < 40) {
                    pixel_arr.add("1");
                } else {
                    pixel_arr.add("0");
                }

                if (gapg < 20 && gapb< 20 && r < 40) {
                    pixel_arr_rw.add("0");
                } else if (r == g && r == b) {
                    pixel_arr_rw.add("0"); // 纯白
                } else if (r > 120 && (g + b) < 160) {
                    pixel_arr_rw.add("1");
                } else {
                    pixel_arr_rw.add("0"); // 纯白
                }
            }
        }
        int index = 0;
        pixel_arr.addAll(pixel_arr_rw);
        for (int i = 0; i < pixel_arr.size(); i = i + 8) {
            String str = pixel_arr.get(i) + pixel_arr.get(i + 1) + pixel_arr.get(i + 2) + pixel_arr.get(i + 3)
                    + pixel_arr.get(i + 4) + pixel_arr.get(i + 5) + pixel_arr.get(i + 6) + pixel_arr.get(i + 7);
            bytes[index] = (byte)Integer.parseInt(str, 2);
            index++;
//			String hex = Integer.toHexString(Integer.parseInt(str, 2));
//			if (hex.length() == 1) {
//				hex = "0" + hex;
//			}
//			// System.out.println("-->" + hex);
//			pixel_hex.add(hex);
        }
//		System.out.println((int) (pixel_hex.size()));
//		FileWriter writer;
//		try {
//			writer = new FileWriter("/Users/atom/test/arrheizi666.txt");
//			writer.write(String.join("", pixel_hex));
//			writer.flush();
//			writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

        File file = new File(binPath);
        OutputStream os;
        try {
            os = new FileOutputStream(file);
            BufferedInputStream is = new BufferedInputStream(new ByteArrayInputStream(bytes));
//			int len;
            byte[] buf = new byte[ 8];
            while (is.read(buf) != -1) {
                os.write(buf);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}

