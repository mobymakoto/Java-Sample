package com.moby.jms.sample;

import java.io.Serializable;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;

 public class JmsSender {

    private JmsConnector connector = null;

    private JmsSender(String subscribe) throws JMSConnectorException {
        connector = JmsConnector.build(subscribe);
    }

    public static JmsSender buildForQueue()  throws JMSConnectorException {
        return new JmsSender(ParameterRepository.SUBSCRIBE_QUEUE);
    }

    public static JmsSender buildForTopic()  throws JMSConnectorException {
        return new JmsSender(ParameterRepository.SUBSCRIBE_TOPIC);
    }

    public void send(String message) throws JMSException, NamingException {
       send(connector.getSession().createTextMessage(message));
    }

    public void send(Serializable message) throws JMSException, NamingException {
        send((ObjectMessage)connector.getSession().createObjectMessage(message));
    }

    public void close() throws JMSException {
        connector.close();
    }

    private void send(Message message) throws JMSException {
        connector.getMessageProducer().send(message);
    }

}
