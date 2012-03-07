package com.moby.jms.sample;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParameterRepositoryTest {

    @Test
    public void testCreateParameterRepository() {
        try {
            assertNotNull(ParameterRepository.createParameterRepository("queue"));
            assertNotNull(ParameterRepository.createParameterRepository("topic"));
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFactoryName() {
        String factoryName = null;
        try {
            factoryName = ParameterRepository.createParameterRepository("queue").getFactoryName();
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
        assertEquals("org.exolab.jms.jndi.InitialContextFactory", factoryName);
    }

    @Test
    public void testGetProviderUrl() {
        String providerUrl = null;
        try {
            providerUrl = ParameterRepository.createParameterRepository("queue").getProviderUrl();
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
        assertEquals("rmi://localhost:1099/", providerUrl);
    }

    @Test
    public void testGetConnectionFactory() {
        String queueConnectionFactory = null;
        String topicConnectionFactory = null;
        try {
            queueConnectionFactory = ParameterRepository.createParameterRepository("queue").getConnectionFactory();
            topicConnectionFactory = ParameterRepository.createParameterRepository("topic").getConnectionFactory();
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
        assertEquals("JmsQueueConnectionFactory", queueConnectionFactory);
        assertEquals("JmsTopicConnectionFactory", topicConnectionFactory);
    }

    @Test
    public void testGetSubscribe() {
        String queue = null;
        String topic = null;
        try {
            queue = ParameterRepository.createParameterRepository("queue").getSubscribe();
            topic = ParameterRepository.createParameterRepository("topic").getSubscribe();
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
        assertEquals("queue1", queue);
        assertEquals("topic1", topic);
    }

}
