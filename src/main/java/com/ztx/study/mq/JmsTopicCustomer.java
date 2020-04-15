package com.ztx.study.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsTopicCustomer {

    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    public static final String QUEUE_NAME = "queue001";
    public static final String TOPIC_NAME = "topic001";

    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", ACTIVEMQ_URL);
        Connection connection = factory.createConnection();
        connection.setClientID("client001");

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);

        TopicSubscriber consumer = session.createDurableSubscriber(topic, "client1-sub");
        connection.start();

        consumer.setMessageListener(new MessageListener(){
            @Override
            public void onMessage(Message message){
                if(null != message && message instanceof TextMessage){
                    TextMessage text = (TextMessage)message;
                    try {
                        System.out.println("消费者消费:"+text.getText());
                    } catch (JMSException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });

        System.in.read();

        session.close();
        connection.close();
    }
}
