package com.demo.activeMQ;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息监听
 * @author Administrator
 *
 */
public class Listener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(1000);
            System.out.println("消费者收到的消息："+((TextMessage)message).getText());
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
