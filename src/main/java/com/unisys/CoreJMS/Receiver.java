package com.unisys.CoreJMS;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;

import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Receiver 
{
  private ConnectionFactory cf  = null;
  private Connection        con = null;
  private Session sess = null;
  private MessageConsumer consumer = null;
  private Destination dest = null;
  
  public void receiveMessage() {
    cf=new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
    try {
      con=cf.createConnection();
      con.start();
      sess=con.createSession(false, Session.AUTO_ACKNOWLEDGE);
      dest=sess.createQueue("AshokBharat1Queue");
      consumer=sess.createConsumer(dest);
      
      Message msg = consumer.receive();
      String msgText=null;
      if(msg instanceof TextMessage){
        msgText = ((TextMessage) msg).getText();
      }
      System.out.println("Received message.."+msgText);
      
      
    } catch (JMSException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
}
