package com.demo.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 发布端
 */
public class PublishExample {

    public static String topic = "/BeesmartEmit/D07B064B7B723955A0759344C82356D1/1DFAAB514F38167D20875A7B2E0C9A9E";
    public static String content = "eyJjbWQiOiAzODE1LCJleHRlbmQiOiB7ImNtZCI6IDIwMDAsICJjbWRfaWQiOiAiMzg0" +
            "NSIsImlucHV0Ijp7ImFwX21hYyI6IjNjIDcxIDY2IGFhIDI5IDhiIiwiY21kIjoiUGljdHVyZVV" +
            "wZGF0ZSIsImNvb3JkIjoiZmYiLCJlbmQiOjAsImZyZXEiOjMsImxpZ2h0Ijp0cnVlLCJub3" +
            "ciOjAsInBpY3R1cmVfcGF0aCI6Imh0dHA6Ly8xOTIuMTY4LjMuMjc6OTAvaW1hZ2VzL" +
            "zIwMTkwOTA2LyIsInByaWNldGFnX21hYyI6IjQwIDAwIDAwIDAwIDAwIDRhIDg5IDA" +
            "wIDAwIDAwIiwic3RhcnQiOjAsIndvcmtfbW9kZSI6MH19LAoic2VyX2lkIjogIjEyMzMy" +
            "MTQ1NiIKfQ==";
    public static String broker = "tcp://127.0.0.1:1883";
    public static String userName = "admin";
    public static String password = "admin";
    public static String clientId = "8765432102";
    public static int qos = 0;

    // 内存存储
    public static MemoryPersistence persistence = new MemoryPersistence();

    public static void main(String[] args) {
        try {
            // 1.创建客户端 //borker = "tcp://127.0.0.1:1883" ;clientId = "8765432102";
            MqttClient client = new MqttClient(broker, clientId, persistence);
            // 2.创建连接参数
            MqttConnectOptions options = new MqttConnectOptions();
            // 3.在重新启动和重新连接时记住状态
            options.setCleanSession(true);
            // 4.设置连接的用户名和密码
            options.setUserName(userName);
            options.setPassword(password.toCharArray());
            // 5.建立连接
            client.connect(options);
            // 6.创建消息
            MqttMessage message = new MqttMessage(content.getBytes());
            // 7.设置消息的服务质量
            message.setQos(qos);
            String newDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println(newDate+":发布消息");
                // 8.发布消息
//                client.publish(topic, message);
            System.out.println("发布成功");
            // 9.断开连接
            client.disconnect();
            // 10.关闭客户端
            client.close();
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }

    public static void saveInfo(String str){
        try {
            // 1.创建客户端 //borker = "tcp://127.0.0.1:1883" ;clientId = "8765432102";
            MqttClient client = new MqttClient(broker, "123456", persistence);
            // 2.创建连接参数
            MqttConnectOptions options = new MqttConnectOptions();
            // 3.在重新启动和重新连接时记住状态
            options.setCleanSession(true);
            // 4.设置连接的用户名和密码
            options.setUserName(userName);
            options.setPassword(password.toCharArray());
            // 5.建立连接
            client.connect(options);
            // 6.创建消息
            MqttMessage message = new MqttMessage(str.getBytes());
            // 7.设置消息的服务质量
            message.setQos(qos);
            // 8.发布消息
            client.publish("/test/", message);
            // 9.断开连接
            client.disconnect();
            // 10.关闭客户端
            client.close();
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }

}



