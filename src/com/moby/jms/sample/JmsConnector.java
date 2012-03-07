package com.moby.jms.sample;

import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JmsConnector {

     private Hashtable<String, String> properties = new Hashtable<>();

     // Q: QueueConnectionFactory,  T: TopicConnectionFactory
     private ConnectionFactory factory = null;
     // Q: QueueConnection,  T: TopicConnection
     private Connection connection = null;
     // Q: QueueSession,  T: TopicSession
     private Session session = null;
     // Q: Queue,  T: Topic
     private Destination dist = null;

     private ParameterRepository paramRepository = null;

     private JmsConnector(String subscribe) throws JMSConnectorException {
         paramRepository = ParameterRepository.createParameterRepository(subscribe);
         ready();
     }

     protected static JmsConnector build(String subscribe) throws JMSConnectorException {
         return new JmsConnector(subscribe);
     }

     protected Session getSession() {
         return session;
     }

     protected MessageProducer getMessageProducer() throws JMSException {
        return session.createProducer(dist);
     }

     protected MessageConsumer getMessageConsumger() throws JMSException {
         return session.createConsumer(dist);
     }

     protected void close() throws JMSException {
         connection.stop();
         session.close();
         connection.close();
     }

    private void ready() throws JMSConnectorException {
        try {
            properties.put(Context.INITIAL_CONTEXT_FACTORY,  paramRepository.getFactoryName());
            properties.put(Context.PROVIDER_URL, paramRepository.getProviderUrl());
            Context context = new InitialContext(properties);
            factory = (ConnectionFactory)context.lookup(paramRepository.getConnectionFactory());
            connection  = factory.createConnection();
            connection.start();
            session = connection.createSession(false,  Session.AUTO_ACKNOWLEDGE);
            dist = (Destination)context.lookup(paramRepository.getSubscribe());
        } catch(Exception e) {
            throw new JMSConnectorException(e); 
        }
    }

}
