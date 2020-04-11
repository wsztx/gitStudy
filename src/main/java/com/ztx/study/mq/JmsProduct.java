package com.ztx.study.mq;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsProduct {
	
	public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
	public static final String QUEUE_NAME = "queue001";

	public static void main(String[] args) throws JMSException {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue(QUEUE_NAME);
		
		MessageProducer product = session.createProducer(queue);
		for(int i = 1; i<=3; i++){
			TextMessage message = session.createTextMessage("***我的消息"+i);
			product.send(message);
			System.out.println("生产者生产:"+message.getText());
		}
		
		product.close();
		session.close();
		connection.close();
	}

}
