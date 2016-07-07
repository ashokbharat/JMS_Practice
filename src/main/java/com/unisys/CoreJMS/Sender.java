package com.unisys.CoreJMS;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Sender
{
  private ConnectionFactory cf  = null;
  private Connection        con = null;
  private Session sess = null;
  private MessageProducer producer = null;
  private Destination dest = null;
  
  public void sendMessage() {
    cf=new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
    try {
      con=cf.createConnection();
      con.start();
      sess=con.createSession(false, Session.AUTO_ACKNOWLEDGE);
      dest=sess.createQueue("GirijaBharatQueue");
      producer=sess.createProducer(dest);
      TextMessage msg = sess.createTextMessage();
      msg.setText("Sending a message from.."+Thread.currentThread().getName());
      
      System.out.println("GirijaBharat is sending the message\n");
      producer.send(msg);
      
      if(con!=null && sess!=null){
        sess.close();
        con.close();
      }
    } catch (JMSException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
}
