package com.demo.html2Image;

import gui.ava.html.image.generator.HtmlImageGenerator;

public class Html2ImageTest {

    public static void main(String[] args) {
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        String htmlstr = "<div style='border:solid 1px #009688;width: 610px;height: 485px;'>" +
                "<img src='file:///E:/myimags/image/background/timg%20(1).jpg'></div>";
        
        String htm = "<div style=\"width: 500px; height: 400px;position: relative;background-image: " +
                "url(&quot;file:///E:/myimags/image/background/timg%20(1).jpg&quot;);" +
                " background-size: 100% 100%;\" id=\"divChildren\"><div class=\"layui-this\" " +
                "style=\"position: absolute;left: 0px;top: 0px; color: black;font-size: 20px; " +
                "line-height: 20px;min-height: 20px; font-family: simhei;margin: auto;" +
                "white-space: nowrap;display: block; border: none; min-width: 50px;cursor: pointer;\" contenteditable=\"true\">新建文本</div><img " +
                "class=\"\" src=\"file:///E:/myimags/image/background/timg%20(1).jpg\" style=\"display: block; position: absolute; " +
                "left: 53%; top: 60%; width: 200px; height: 150px; cursor: pointer; border: 1px dashed rgb(221, 221, 221);\">" +
                "<img src=\"file:///E:/myimags/image/background/timg%20(1).jpg\" style=\"display: block; " +
                "position: absolute; left: 0%; top: 44%; width: 260px; height: 220px; cursor: pointer;" +
                " border: 1px dashed rgb(221, 221, 221);\" class=\"layui-this class-float\"></div>";

        String htmltest = "<div style=\"width: 798px;height: 478px;position: relative;margin: 0 auto;\n" +
                "    \t\tborder: solid 1px #009688;\" id=\"divChildren\">\n" +
                "\t        <div id=\"box11151834476\" class=\"layui-this class-float\"\n" +
                "\t             style=\"position: absolute; left: 50%; top: 40%; z-index: 5; color: black;\n" +
                "\t              font-size: 45px; font-weight: bold; line-height: 20px; min-height: 20px;\n" +
                "\t              font-family: simhei; margin: auto; white-space: nowrap; display: block;\n" +
                "\t              border: none; min-width: 50px; cursor: pointer; transform: translateX(-50%);\"\n" +
                "\t             contenteditable=\"true\">新建文本</div>\n" +
                "\t        </div>";


        imageGenerator.loadHtml(htmltest); // 加载html源码内容
        try {
            Thread.sleep(1000); //有时会有加载图片延迟，因此这里设置下延时
            imageGenerator.getBufferedImage();// 生成图片字符流
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //此方式生成的图片，如果html结构里含有图片，则生成的图片显示和页面上的原图会有较大偏差
        imageGenerator.saveAsImage("E:/image/3007.png"); // 保存到本地
        System.out.println("----end----");

    }
}
