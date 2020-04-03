package com.demo.html2Image;

import gui.ava.html.image.generator.HtmlImageGenerator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.awt.*;
import java.util.Iterator;

public class HtmlTest2 {
    public static void main(String[] args) {
//        String html = "<div style=\"width: 600px; height: 480px;position: relative; background-image: " +
//                "url(&quot;file:///E:/image/20190820/9df59c41e0c64254864883c6aa627703.jpg&quot;); " +
//                "background-size: 100% 100%;\" id=\"divChildren\"><div class=\"layui-this\" style=\"position: absolute;" +
//                "left: 0px;top: 0px; color: black;font-size: 20px; line-height: 20px;min-height: 20px; font-family: simhei;" +
//                "margin: auto;white-space: nowrap;display: block; border: none; min-width: 50px;" +
//                "cursor: pointer;\" contenteditable=\"true\">新建文本</div><img class=\"layui-this class-float\" " +
//                "src=\"file:///E:/image/20190820/2c657eb73daf42efa8c98d2aa7017e12.jpg\" style=\"display: block; " +
//                "position: absolute; left: 8%; top: 29%; width: 200px; height: 320px; cursor: pointer; " +
//                "border: 1px dashed rgb(221, 221, 221);\">" +
//                "<img src=\"file:///E:/image/20190820/4eae424cb0804c368e88bc120cf6a4bb.jpg\" " +
//                "style=\"display: block; position: absolute; left: 43%; top: 32%; width: 330px; height: 300px; " +
//                "cursor: pointer; border: 1px dashed rgb(221, 221, 221);\" class=\"\"></div>";

        String html = "<div style=\"width: 500px; height: 400px;position: relative;background-image: " +
                "url(&quot;file:///E:/image/20190820/9df59c41e0c64254864883c6aa627703.jpg&quot;);" +
                " background-size: 100% 100%;\" id=\"divChildren\"><div class=\"layui-this\" " +
                "style=\"position: absolute;left: 0px;top: 0px; color: black;font-size: 20px; " +
                "line-height: 20px;min-height: 20px; font-family: simhei;margin: auto;" +
                "white-space: nowrap;display: block; border: none; min-width: 50px;cursor: pointer;\" contenteditable=\"true\">新建文本</div>" +
                "<img src=\"file:///E:/myimags/image/background/timg%20(1).jpg\" style=\"display: block; " +
                "position: absolute; left: 0%; top: 44%; width: 260px; height: 220px; cursor: pointer;" +
                " border: 1px dashed rgb(221, 221, 221);\" class=\"layui-this class-float\"></div>";

        String str = "<div style=\"width: 500px; height: 400px;background-color:#EFEFEF;\">靠靠靠啊靠啊靠啊靠" +
                "<img style=\"width: 100px; height: 100px;display:block;\" src=\"file:///E:/image/20190820/9df59c41e0c64254864883c6aa627703.jpg\">" +
                "</div>";

        String test = "<div id=\"fatherDiv\" class=\"layui-row\" style=\"margin: 0px auto; height: 498px; width: 1000px;\">\n" +
                "\n" +
                "    \t<div style=\"width: 798px;height: 478px;position: relative;top: 10px;margin: 0 auto;\n" +
                "    \t\tborder: solid 1px #009688;\" id=\"divChildren\">\n" +
                "\t        <div id=\"box11151834476\" class=\"layui-this class-float\"\n" +
                "\t             style=\"position: absolute; left: 50%; top: 40%; z-index: 5; color: black;\n" +
                "\t              font-size: 45px; font-weight: bold; line-height: 20px; min-height: 20px;\n" +
                "\t              font-family: simhei; margin: auto; white-space: nowrap; display: block;\n" +
                "\t              border: none; min-width: 50px; cursor: pointer; transform: translateX(-50%);\"\n" +
                "\t             contenteditable=\"true\">新建文本</div>\n" +
                "\t        </div>\n" +
                "    \t</div>";

        // 获取html文档。
        Document document = Jsoup.parse(test);
        // 拿到全部img标签，并设置src属性
//        Iterator<Element> imgs = document.select("img").iterator();
//        while (imgs.hasNext()) {
//            Element img = imgs.next();
//            img.attr("src", "file:///E:/myimags/image/background/timg%20(1).jpg");
//        }
        //打印dom结构
        System.out.println(document);
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        Dimension dimension = new Dimension(800,480);
        imageGenerator.setSize(dimension);
        imageGenerator.loadHtml(String.valueOf(document)); // 加载html源码内容

        try {
            Thread.sleep(3000); //有时会有加载图片延迟，因此这里设置下延时
            imageGenerator.getBufferedImage();// 生成图片字符流
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        imageGenerator.getLinks();//列出所有在HTML文档的链接和相应href、目标、头衔、位置和尺寸

        //以图片形式保存html结构
        imageGenerator.saveAsImage("E:/image/800480.png"); // 保存到本地
        System.out.println("----end----");
    }
}
