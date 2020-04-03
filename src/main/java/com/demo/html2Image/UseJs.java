package com.demo.html2Image;

import org.hibernate.validator.internal.util.privilegedactions.GetResource;
import org.springframework.util.ResourceUtils;

import javax.script.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class UseJs {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, FileNotFoundException {
        ScriptEngine engine=new ScriptEngineManager().getEngineByName("javascript");
        //建立上下文
        Bindings bind=engine.createBindings();
        bind.put("factor",1);
        System.out.println("请输入初始化参数：");
        Scanner input=new Scanner(System.in);
        String item=input.nextLine();
        while(item!="exit"){

//            String filePath = GetResource.class.getClassLoader().getResource("static/plugin/test/lap.js").getPath();
//            System.out.println("lap.js的路径:"+filePath);

            //通过相对路径读取文件,linux下此方法 读取不到对应路径及文件
            File resourcesPath = ResourceUtils.getFile("classpath:static/plugin/test/");
            System.out.println("路径:"+resourcesPath.getPath());

            File fil= ResourceUtils.getFile("classpath:static/plugin/test/lap.js");
            System.out.println("通过相对路径获取的路径:"+fil.getPath());
            Object eval = engine.eval(new FileReader(fil));
            //通过绝对路径读取
//            Object eval = engine.eval(new FileReader("D:\\IDEA-Project\\mybatus-demo\\src\\main\\resources\\static\\plugin\\test\\lap.js"));
            if(engine instanceof Invocable){
                System.out.println("输入参数："+item);
                Invocable in= (Invocable) engine;
                String result= (String) in.invokeFunction("printWord",item);
                System.out.println("运算结果："+result.toString());
            }
            System.out.println("请再次输入参数：");
            item=input.nextLine();
        }
    }
}
