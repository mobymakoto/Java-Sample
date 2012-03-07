package com.moby.jms.sample;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParameterLoaderTest {

    @Test
    public void testGetFactoryName() {
        try {
            assertEquals("org.exolab.jms.jndi.InitialContextFactory", new ParameterLoader().getFactoryName());
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetProviderUrl() {
        try {
            assertEquals("rmi://localhost:1099/", new ParameterLoader().getProviderUrl());
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetQueueConnectionFactory() {
        try {
            assertEquals("JmsQueueConnectionFactory", new ParameterLoader().getQueueConnectionFactory());
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetQueueName() {
        try {
            assertEquals("queue1", new ParameterLoader().getQueueName());
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetTopicConnectionFactory() {
        try {
            assertEquals("JmsTopicConnectionFactory", new ParameterLoader().getTopicConnectionFactory());
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetTopicName() {
        try {
            assertEquals("topic1", new ParameterLoader().getTopicName());
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
    }

}
