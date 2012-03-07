package com.moby.jms.sample;

import static org.junit.Assert.*;

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
        fail("まだ実装されていません");
    }

    @Test
    public void testGetMessageProducer() {
        fail("まだ実装されていません");
    }

    @Test
    public void testGetMessageConsumger() {
        fail("まだ実装されていません");
    }

}
