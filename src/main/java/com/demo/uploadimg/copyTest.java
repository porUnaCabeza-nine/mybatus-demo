package com.demo.uploadimg;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyTest {

    /**
     *
     * <b>Summary: </b> copyFile 保存上传文件 String
     *
     * @param saveName
     *
     * @param file
     * @return copyFile Dec 6, 2013
     */
    private String uploadFile(HttpServletRequest request, String realpath, String saveName, File file) {
        // 数据流方式上传文件
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            realpath = "upload/"+realpath; //realpath
            realpath = request.getSession().getServletContext().getRealPath(realpath);
            System.out.println("上传路径.."+realpath);
            File dirFile = new File(realpath);
            if (!dirFile.isDirectory()) {// 目录月份目录不存在
                dirFile.mkdirs();// 创建目录
            }
            // 建立文件输出流
            fos = new FileOutputStream(realpath + "/" + saveName);
            // 建立文件上传流
            fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        } catch (Exception e) {
            System.out.println("文件上传失败");
            e.printStackTrace();
            return "error";
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("FileInputStream关闭失败");
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    System.out.println("FileOutputStream关闭失败");
                    e.printStackTrace();
                }
            }
        }
        return "success";
    }
}
