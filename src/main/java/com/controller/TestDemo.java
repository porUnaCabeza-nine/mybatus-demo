package com.controller;

import com.alibaba.fastjson.JSON;
import com.demo.html2Image.phontomjs_img.phontomjs.Screenshot;
import com.demo.uploadimg.UploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronExpression;
import org.quartz.TriggerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class TestDemo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value = "")
    public String loginInit() {
        return goLogin();
    }

    /*
    * 测试数据库连接，返回json数据
    * */
    @RequestMapping(value = "/test")
    @ResponseBody
    public List<Map<String, Object>> test() {
        //String sql = "select * from zv_hpuser limit 0,5";
        String sql = "select * from  (select" +
                "        group_concat(B.className) As className," +
                "        colorCode,DATE_FORMAT(A.rosterDate, '%Y-%m-%d') As rosterDate," +
                "        A.classId,A.memo" +
                "        From zv_dutyroster A" +
                "        Left Join zv_dutyclass B On A.classid=B.id" +
                "        GROUP BY className" +
                "        Order By className) as dutyList  where className is not null  LIMIT 1";
//        log.info("sql打印:"+sql);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            if (entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key + ":" + value);
                }
            }
        }
        return list;
    }
    @Autowired
    UploadUtil uploadUtil;

    @PostMapping(value = "/upload")
    @ResponseBody
    public String imgUpload(HttpServletRequest req, @RequestParam("file") MultipartFile file) {
        System.out.println("上传开始");
        String fileName=uploadUtil.upload(file);
        System.out.println("上传结束");
        return "";
    }

    /**
     * @Description //测试屏幕截图
     * @Author ljc
     * @Date  2019/10/28 16:09
     * @return
     **/
    @RequestMapping(value = "/testPhantomjs")
    @ResponseBody
    public String testPhantomjs() {
        String url = "http://39.98.89.166:9380/ddzp-api/test2.html";
//        String url = "https://news.163.com/"; //网易新闻
//        String url ="http://39.98.89.166:9380/dzzp/images/20191028/b282a6cbf0a64f528777f89672b46781.png";
//        String jsPath =   System.getProperty("user.dir") + "/configFile/baidu.js";   //截取全屏 一直到滚动条底部
        String jsPath =   System.getProperty("user.dir") + "/configFile/rasterize.js";   //截取div
//        String jsPath = "D:\\AllSummaryFiles\\test/baidu.js";
        String imgpath = "/zp11.png";
        //String jsPath = System.getProperty("user.dir") + "\\target\\js\\baidu.js"; //windows
        Screenshot.screenshot(url, imgpath, jsPath, "");

        return "sucess";
    }




    @GetMapping(value = "/login")
    public String goLogin() {
//        log.info("进入登陆页面!");
        return "login";
    }

    @GetMapping(value = "/cron")
    public String cron() {
//        log.info("进入登陆页面!");
        return "/main/cron";
    }

    /**
     * @Description //TODO
     * @Author ljc
     * @Date  2019/11/28 9:53
     * @Param [cronExpression：传递的cron表达式参数]
     * @return 返回最近5次的结果时间
     **/
    @RequestMapping("/cron/expression")
    @ResponseBody
    public List<String> expression(String cronExpression){
        System.out.println("传递的表达式参数:"+cronExpression);
        //执行次数
        int numTimes = 5;

        List<String> list = new ArrayList<>();
        CronTriggerImpl cronTriggerImpl = new CronTriggerImpl();
        try {
            cronTriggerImpl.setCronExpression(cronExpression);
        } catch(ParseException e) {
            e.printStackTrace();
        }
        //解析cron表达式
        List<Date> dates = TriggerUtils.computeFireTimes(cronTriggerImpl, null, numTimes);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Date date : dates) {
            list.add(dateFormat.format(date));
        }
        System.out.println("五次执行的时间:"+JSON.toJSONString(list));
        return list;
    }


}
