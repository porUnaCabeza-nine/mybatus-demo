package com.demo.html2Image.img;

import java.io.*;

/**
 * 二进制读取和写入 拷贝文件
 */
public class CopyBinary{


    public static void main(String[] args) {
        File srcFile = new File("E:\\TIM20190826101435.png");
        File outFile = new File("E:\\TIM235.bin");
        try {
            CopyBinary.copy(srcFile,outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("success");
    }

    public static long copy(File srcFile, File outFile) throws IOException {
        FileInputStream fis = null;
        DataInputStream dis = null;
        FileOutputStream fos = null;
        DataOutputStream out = null;
        long size = 0;
        try {
            fis = new FileInputStream(srcFile);
            dis = new DataInputStream(fis);
            fos = new FileOutputStream(outFile);
            out = new DataOutputStream(fos);
            int temp;
            byte[] b = new byte[2048];
            while ((temp = dis.read(b)) != -1) {
                fos.write(b);
                size += temp;
            }
        } catch (FileNotFoundException ex) {
            throw ex;
        } finally {
            if (fis != null)
                fis.close();
            if (out != null)
                out.close();
        }
        return size;
    }

    public static long copy(String srcFilePath, String destFilePath)
            throws Exception {
        if (srcFilePath == null) {
            throw new Exception("srcFilePath is null");
        }
        if(destFilePath == null){
            throw new Exception("destFilePath is null");
        }
        return copy(new File(srcFilePath), new File(destFilePath));
    }
}




