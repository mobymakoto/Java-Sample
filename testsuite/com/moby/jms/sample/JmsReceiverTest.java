package com.moby.jms.sample;

import static org.junit.Assert.*;

import javax.jms.JMSException;
import javax.naming.NamingException;

import org.junit.Test;

import com.moby.jms.sample.JMSConnectorException;
import com.moby.jms.sample.JmsReceiver;

public class JmsReceiverTest {

    @Test
    public void testBuildForQueue() {
        try {
            assertNotNull(JmsReceiver.buildForQueue());
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBuildForTopic() {
        try {
            assertNotNull(JmsReceiver.buildForTopic());
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReceiveString() {
        try {
            System.out.println(" Received : " + JmsReceiver.buildForQueue().receiveString());
        } catch (JMSException | NamingException | JMSConnectorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReceiveObject() {
        try {
            System.out.println(" Received : " + JmsReceiver.buildForTopic().receiveObject());
        } catch (JMSException | NamingException | JMSConnectorException e) {
            e.printStackTrace();
        }
    }

}
