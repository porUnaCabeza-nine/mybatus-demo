package com.demo.mqtt;

import org.fusesource.hawtbuf.Buffer;
import org.fusesource.hawtbuf.UTF8Buffer;
import org.fusesource.mqtt.client.*;
import org.fusesource.mqtt.codec.MQTTFrame;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class MqttImplRunnable implements Runnable {


    private String host;

    private boolean cleanSession;

    private short keepAlive;

    private String uname;

    private String pwd;

    public MqttImplRunnable(String host, boolean cleanSession, short keepAlive, String uname, String pwd) {
        this.host = host;
        this.cleanSession = cleanSession;
        this.keepAlive = keepAlive;
        this.uname = uname;
        this.pwd = pwd;
    }

    @Override
    public void run() {
        try {
            MQTT mqtt = new MQTT();
            //MQTT设置说明
            mqtt.setHost(host);
            mqtt.setClientId("876543210"); //用于设置客户端会话的ID。在setCleanSession(false);被调用时，MQTT服务器利用该ID获得相应的会话。此ID应少于23个字符，默认根据本机地址、端口和时间自动生成
            mqtt.setCleanSession(cleanSession); //若设为false，MQTT服务器将持久化客户端会话的主体订阅和ACK位置，默认为true
            mqtt.setKeepAlive(keepAlive);//定义客户端传来消息的最大时间间隔秒数，服务器可以据此判断与客户端的连接是否已经断开，从而避免TCP/IP超时的长时间等待
            mqtt.setUserName(uname);//服务器认证用户名
            mqtt.setPassword(pwd);//服务器认证密码

            mqtt.setWillTopic("willTopic");//设置“遗嘱”消息的话题，若客户端与服务器之间的连接意外中断，服务器将发布客户端的“遗嘱”消息
            mqtt.setWillMessage("willMessage");//设置“遗嘱”消息的内容，默认是长度为零的消息
            mqtt.setWillQos(QoS.AT_LEAST_ONCE);//设置“遗嘱”消息的QoS，默认为QoS.ATMOSTONCE
            mqtt.setWillRetain(true);//若想要在发布“遗嘱”消息时拥有retain选项，则为true
            mqtt.setVersion("3.1.1");

            //失败重连接设置说明
            mqtt.setConnectAttemptsMax(10L);//客户端首次连接到服务器时，连接的最大重试次数，超出该次数客户端将返回错误。-1意为无重试上限，默认为-1
            mqtt.setReconnectAttemptsMax(3L);//客户端已经连接到服务器，但因某种原因连接断开时的最大重试次数，超出该次数客户端将返回错误。-1意为无重试上限，默认为-1
            mqtt.setReconnectDelay(10L);//首次重连接间隔毫秒数，默认为10ms
            mqtt.setReconnectDelayMax(30000L);//重连接间隔毫秒数，默认为30000ms
            mqtt.setReconnectBackOffMultiplier(2);//设置重连接指数回归。设置为1则停用指数回归，默认为2

            //Socket设置说明
            mqtt.setReceiveBufferSize(65536);//设置socket接收缓冲区大小，默认为65536（64k）
            mqtt.setSendBufferSize(65536);//设置socket发送缓冲区大小，默认为65536（64k）
            mqtt.setTrafficClass(8);//设置发送数据包头的流量类型或服务类型字段，默认为8，意为吞吐量最大化传输

            //带宽限制设置说明
            mqtt.setMaxReadRate(0);//设置连接的最大接收速率，单位为bytes/s。默认为0，即无限制
            mqtt.setMaxWriteRate(0);//设置连接的最大发送速率，单位为bytes/s。默认为0，即无限制

            //选择消息分发队列
            //若没有调用方法setDispatchQueue，客户端将为连接新建一个队列。如果想实现多个连接使用公用的队列，显式地指定队列是一个非常方便的实现方法
//            mqtt.setDispatchQueue(Dispatch.createQueue("foo"));

            //设置跟踪器
            mqtt.setTracer(new Tracer() {
                @Override
                public void onReceive(MQTTFrame frame) {
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()) +";接收: " + frame);
                }

                @Override
                public void onSend(MQTTFrame frame) {
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()) +";发送: " + frame.toString());
                }

                @Override
                public void debug(String message, Object... args) {
                    System.out.println(String.format("debug: " + message, args));
                }
            });
            //使用回调式API
            final CallbackConnection callbackConnection = mqtt.callbackConnection();
            //连接监听
            callbackConnection.listener(new Listener() {
                //接收订阅话题发布的消息
                @Override
                public void onPublish(UTF8Buffer topic, Buffer payload, Runnable onComplete) {
                    String newDate = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date());
                    /***增加业务处理逻辑，处理所有的上行消息，包含解析所有ap状态、桌牌状态 ***/
                    String receiveBase64 = new String(payload.toByteArray());
                    if (receiveBase64 != null && receiveBase64.length() != 0) {
                        System.out.println("收到消息");
                        System.out.println("topic" + topic.toString() + "=" + newDate + "=receive msg；ap上报的base64码：" + receiveBase64);
                        String decodeStr = null;
                        try {
                            decodeStr = new String(Base64.getDecoder().decode(receiveBase64), "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        System.out.println("解密后:" + decodeStr);
                        System.out.println("保存到另一个主题");
                        PublishExample.saveInfo(decodeStr);

                    } else {
                        System.out.println("没有消息啊");
                    }
                    onComplete.run();
                }
                //连接失败
                @Override
                public void onFailure(Throwable value) {
                    System.out.println("===========connect failure===========");
                    callbackConnection.disconnect(null);
                }

                //连接断开
                @Override
                public void onDisconnected() {
                    System.out.println("====mqtt disconnected=====");
                }

                //连接成功
                @Override
                public void onConnected() {
                    System.out.println("====mqtt connected=====");
                }
            });

            //连接
            callbackConnection.connect(new Callback<Void>() {
                //连接失败
                public void onFailure(Throwable value) {
                    System.out.println("============连接失败：" + value.getLocalizedMessage() + "============");
                }

                // 连接成功
                public void onSuccess(Void v) {
                    //订阅主题
                    Topic[] topics = {new Topic("/BeesmartReport/#", QoS.AT_LEAST_ONCE)};
                    callbackConnection.subscribe(topics, new Callback<byte[]>() {
                        //订阅主题成功
                        public void onSuccess(byte[] qoses) {
                            System.out.println("========订阅成功=======");
                        }
                        //订阅主题失败
                        public void onFailure(Throwable value) {
                            System.out.println("========订阅失败=======");
                            callbackConnection.disconnect(null);
                        }
                    });
                }
            });
            while (true) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
