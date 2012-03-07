package com.moby.jms.sample.testsuite;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.jms.JMSException;
import javax.naming.NamingException;

import org.junit.Test;

import com.moby.jms.sample.JMSConnectorException;
import com.moby.jms.sample.JmsSender;

public class JmsSenderTest {

    @Test
    public void testBuildForQueue() {
        try {
            assertNotNull(JmsSender.buildForQueue());
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBuildForTopic() {
        try {
            assertNotNull(JmsSender.buildForTopic());
        } catch (JMSConnectorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSendString() {
            try {
                JmsSender.buildForTopic().send("Testing message by Q...");
            } catch (JMSException | NamingException | JMSConnectorException e) {
                e.printStackTrace();
            }
    }

    @Test
    public void testSendSerializable() {
        ArrayList<Integer> list = new  ArrayList<>();
        list.add(100);
        try {
            JmsSender.buildForTopic().send(list);
        } catch (JMSException | NamingException | JMSConnectorException e) {
            e.printStackTrace();
        } 
    }

}
