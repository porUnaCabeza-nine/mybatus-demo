package com.demo.html2Image;

import gui.ava.html.image.generator.HtmlImageGenerator;

public class Test {
    public static void main(String[] args) {
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        String htmlstr = "<div><h1>Hellow-World</h1></div>";
        imageGenerator.loadHtml(htmlstr);
        imageGenerator.getBufferedImage();
        //生成图片
        imageGenerator.saveAsImage("d:/hello-world.png");
        //生成html文件。
        imageGenerator.saveAsHtmlWithMap("d:/hello-world.html", "hello-world.png");
    }

}
