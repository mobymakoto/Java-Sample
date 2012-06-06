package com.moby.jms.sample;


public class ParameterRepository {

    protected static final String SUBSCRIBE_QUEUE = "queue";
    protected static final String SUBSCRIBE_TOPIC = "topic";

   private String factoryName = null;
   private String providerUrl = null;
   private String connectionFactory = null;
   private String subscribe = null;


   private ParameterRepository(String subscribe) throws JMSConnectorException {
       composite(subscribe);
   }

   protected static ParameterRepository createParameterRepository(String subscribe) throws JMSConnectorException {
       return new ParameterRepository(subscribe);
   }

   protected String getFactoryName() {
       return factoryName;
   }

   protected String getProviderUrl() {
       return providerUrl;
   }

   protected String getConnectionFactory() {
       return connectionFactory;
   }

   protected String getSubscribe() {
       return subscribe;
   }

   private void composite(String subscribe) throws  JMSConnectorException {
       if ((subscribe != SUBSCRIBE_QUEUE) && (subscribe != SUBSCRIBE_TOPIC))
           throw new JMSConnectorException(
               new IllegalArgumentException("Invalid argument : " + subscribe));
               
       ParameterLoader loader = new ParameterLoader();
       factoryName = loader.getFactoryName();
       providerUrl = loader.getProviderUrl();
       switch(subscribe) {
       case SUBSCRIBE_QUEUE:
           connectionFactory = loader.getQueueConnectionFactory();
           this.subscribe = loader.getQueueName();
           break;
       case SUBSCRIBE_TOPIC:
           connectionFactory = loader.getTopicConnectionFactory();
           this.subscribe = loader.getTopicName();
           break;
       }
   }

}
