package com.moby.jms.sample;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import javax.naming.NamingException;

public class JmsReceiver {

    private JmsConnector connector = null;

     private JmsReceiver(String subscribe) throws JMSConnectorException  {
         connector = JmsConnector.build(subscribe);
     }

     public static JmsReceiver buildForQueue()  throws JMSConnectorException {
         return new JmsReceiver(ParameterRepository.SUBSCRIBE_QUEUE);
    }

     public static JmsReceiver buildForTopic()  throws JMSConnectorException {
         return new JmsReceiver(ParameterRepository.SUBSCRIBE_TOPIC);
    }

     public String receiveString() throws JMSException, NamingException {
         TextMessage msg = (TextMessage)receive();
         return msg.getText();
     }

     public Object receiveObject() throws JMSException, NamingException {
        ObjectMessage objectMsg = (ObjectMessage)receive();
         return objectMsg.getObject();
     }

    public void close() throws JMSException {
        connector.close();
    }

     private Message receive() throws JMSException, NamingException {
         return  connector.getMessageConsumer().receive();
     }

}
