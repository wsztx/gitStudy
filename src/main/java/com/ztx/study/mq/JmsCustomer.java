package com.ztx.study.mq;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsCustomer {

	public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
	public static final String QUEUE_NAME = "queue001";
	public static final String TOPIC_NAME = "topic001";
	
	public static void main(String[] args) throws JMSException, IOException {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", ACTIVEMQ_URL);
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue(QUEUE_NAME);
		
		MessageConsumer customer = session.createConsumer(queue);
//		while(true){
//			TextMessage message = (TextMessage) customer.receive();
//			if(null != message){
//				System.out.println("消费者消费:"+message.getText());
//			}else{
//				break;
//			}
//		}
		
		customer.setMessageListener(new MessageListener(){
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
		
		customer.close();
		session.close();
		connection.close();
	}

}
