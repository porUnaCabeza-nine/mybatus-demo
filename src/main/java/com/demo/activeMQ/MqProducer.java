package com.demo.activeMQ;

import com.alibaba.druid.util.StringUtils;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 消息生产者
 *
 */
public class MqProducer {

    private static final String USERNAME=ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
    private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
    private static final String BROKEURL=ActiveMQConnection.DEFAULT_BROKER_URL; // 默认的连接地址
    private static final int SENDNUM=10; // 发送的消息数量

    public static  void main(String[] s){
        ConnectionFactory connectionFactory; // 连接工厂
        Connection connection = null; // 连接
        Session session; // 会话 接受或者发送消息的线程
        Destination destination; // 消息的目的地
        MessageProducer messageProducer; // 消息生产者

        // 实例化连接工厂
        connectionFactory=new ActiveMQConnectionFactory(MqProducer.USERNAME, MqProducer.PASSWORD, MqProducer.BROKEURL);
        try {
            connection=connectionFactory.createConnection(); // 通过连接工厂获取连接
            connection.start(); // 启动连接
            session=connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE); // 创建Session
            destination=session.createQueue("this_is_producer"); // 创建消息队列
            messageProducer=session.createProducer(destination); // 创建消息生产者
            sendMessage(session, messageProducer); // 发送消息
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }



    }

    /**
     * 发送消息
     * @param session
     * @param messageProducer
     */
    private static void sendMessage(Session session, MessageProducer messageProducer) throws JMSException, InterruptedException {
        for(int i=0;i<MqProducer.SENDNUM;i++){
//            Thread.sleep(10000);
            String str ="这是生产者"+new SimpleDateFormat("yyyy-MM-dd HH mm ss").format(new Date())
                    +"发送的消息,ActiveMQ已经发送了"+i+"条信息!**********";
            if(StringUtils.isEmpty(str)){
            }
            TextMessage message=session.createTextMessage(str);
            messageProducer.send(message);
        }
        System.out.println("发送完了");
    }


}
