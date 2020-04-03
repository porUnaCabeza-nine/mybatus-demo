package com.demo.html2Image;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CreateHtml {
    public static void main(String[] args) {
        String filePath = "D:\\IDEA-Project\\mybatus-demo\\src\\main\\resources\\static\\plugin\\test\\template.html";
        String imagePath ="D:\\IDEA-Project\\mybatus-demo\\src\\main\\resources\\static\\plugin\\test/QQ.bmp";

        String disrPath = "D:\\IDEA-Project\\mybatus-demo\\src\\main\\resources\\static\\plugin\\test\\";
        String fileName = "aaaaa";
        MakeHtml(filePath,imagePath,disrPath,fileName);
    }
    /**
     * @Title: MakeHtml
     * @Description: 创建html
     * @param    filePath 设定模板文件
     * @param    imagePath 需要显示图片的路径
     * @param    disrPath  生成html的存放路径
     * @param    fileName  生成html名字
     * @return void    返回类型
     * @throws
     */
    public static void MakeHtml(String filePath,String imagePath,String disrPath,String fileName ){
        try {
//            String title = "<image src="+'"'+imagePath+'"'+"/>";

            String title = "<div style=\"width: 798px; height: 478px; background-image: url(&quot;/dzzp/images/20190926/93f1b9e8f1c649bdb851fcff0f304a2b.png&quot;); background-size: 100% 100%;\" id=\"divChildren\"><div id=\"box301355479\" class=\"\" style=\"position: absolute; left: 50%; top: 5%; z-index: 5; color: black; font-size: 70px; font-weight: bold; line-height: 70px; min-height: 20px; font-family: simhei; margin: auto; white-space: nowrap; display: block; border: none; min-width: 50px; cursor: pointer; transform: translateX(-50%);\" contenteditable=\"true\">中华人民共和国</div><div id=\"box30135548706\" style=\"position: absolute; left: 50%; top: 28%; color: black; font-size: 70px; z-index: 5; line-height: 70px; min-height: 20px; font-family: simhei; font-weight: bold; margin: auto; white-space: nowrap; display: block; border: none; min-width: 50px; cursor: pointer; transform: translateX(-50%);\" contenteditable=\"true\" class=\"\">70周年</div><div id=\"box30135550369\" style=\"position: absolute; left: 50%; top: 52%; color: black; font-size: 70px; z-index: 5; line-height: 70px; min-height: 20px; font-family: simhei; font-weight: bold; margin: auto; white-space: nowrap; display: block; border: none; min-width: 50px; cursor: pointer; transform: translateX(-50%);\" contenteditable=\"true\" \n" +
                    "\t\t\t\tclass=\"layui-this class-float\">生日快乐</div></div>";

            System.out.print("html模板路径:"+filePath);
            String templateContent = "";
            FileInputStream fileinputstream = new FileInputStream(filePath);// 读取模板文件
            int lenght = fileinputstream.available();
            byte bytes[] = new byte[lenght];
            fileinputstream.read(bytes);
            fileinputstream.close();
            templateContent = new String(bytes);
            System.out.println("模板html里的内容:"+templateContent);
            templateContent = templateContent.replaceAll("###title###", title);
            System.out.println("替换后的内容"+templateContent);

            String fileame = fileName + ".html";
            fileame = disrPath+"/" + fileame;// 生成的html文件保存路径。
            FileOutputStream fileoutputstream = new FileOutputStream(fileame);// 建立文件输出流
            System.out.println("文件输出路径:");
            System.out.print(fileame);
            byte tag_bytes[] = templateContent.getBytes();
            fileoutputstream.write(tag_bytes);
            fileoutputstream.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

}
