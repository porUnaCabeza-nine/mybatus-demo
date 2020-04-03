package com.demo.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.Base64;

/**
 * @Description: 订阅端
 */
public class SubscribeExample {

    public static String HOST = "tcp://127.0.0.1:1883";
    public static String TOPIC = "/BeesmartEmit/#";
    public static int qos = 1;
    public static String clientId = "876543210";
    public static String userName = "admin";
    public static String password = "admin";

    public static void main(String[] args) throws Exception {
        try {
            // 1.创建客户端
            MqttClient client = new MqttClient(HOST, clientId, new MemoryPersistence());
            // 2.Mqtt的连接设置
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setUserName(userName);
            options.setPassword(password.toCharArray());
            options.setConnectionTimeout(10);
            options.setKeepAliveInterval(20);
            // 3.设置回调函数
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable throwable) {
                    System.out.println("connectionLost");
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("topic:" + topic);
                    System.out.println("Qos:" + message.getQos());
                    String receiveBase64 = new String(message.getPayload());
                    System.out.println("message content:" + receiveBase64);
                    String  decodeStr = new String(Base64.getDecoder().decode(receiveBase64), "UTF-8");
                    System.out.println("解密后:"+decodeStr);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    System.out.println("deliveryComplete---------" + token.isComplete());
                }
            });
            // 4.建立连接
            client.connect(options);
            // 5.订阅消息
            client.subscribe(TOPIC, qos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
