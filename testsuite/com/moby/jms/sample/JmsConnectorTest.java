package com.moby.jms.sample;

import static org.junit.Assert.*;

import javax.jms.JMSException;

import org.junit.Test;

import com.moby.jms.sample.JmsConnector;

public class JmsConnectorTest {

    @Test
    public void testBuild() {
       try {
        assertNotNull(JmsConnector.build("queue"));
    } catch (JMSConnectorException e) {
        e.printStackTrace();
    }
    }

    @Test
    public void testGetSession() {
        try {
            assertNotNull(JmsConnector.build("queue").getSession());
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMessageProducer() {
        try {
            assertNotNull(JmsConnector.build("topic").getMessageProducer());
        } catch (JMSException | JMSConnectorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMessageConsumer() {
        try {
            assertNotNull(JmsConnector.build("topic").getMessageConsumer());
        } catch (JMSException | JMSConnectorException e) {
            e.printStackTrace();
        }
    }

}
