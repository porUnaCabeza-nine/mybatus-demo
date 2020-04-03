package com.demo.html2Image;

import gui.ava.html.image.generator.HtmlImageGenerator;

public class Test2 {
    public static void main(String[] args) {
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        String htmlstr = "<div><h1>Hellow-World</h1></div>";
        String ss = "<div style=\"width: 798px;height: 478px;position: relative;margin: 0 auto;\n" +
                "    \t\tborder: solid 1px #009688;\" id=\"divChildren\"> \n" +
                "    \t<div style=\"text-align: center;font-size: 50px;position: relative;top: 50%;\">\n" +
                "     \t\t新建文本\n" +
                "    \t</div> \n" +
                "   </div>";

        imageGenerator.loadHtml("<div style=\"width: 798px;height: 478px;position: relative;margin: 0 auto;\n" +
                "    \t\tborder: solid 1px #009688;\" id=\"divChildren\"> \n" +
                "    \t<div style=\"text-align: center;font-size: 50px;position: relative;top: 50%;\">\n" +
                "     \t\t新建文本\n" +
                "    \t</div> \n" +
                "   </div>");
        imageGenerator.getBufferedImage();
        //生成图片
        imageGenerator.saveAsImage("d:/test567892323.png");
        //生成html文件。
//        imageGenerator.saveAsHtmlWithMap("d:/test.html", "te.png");
    }

}
