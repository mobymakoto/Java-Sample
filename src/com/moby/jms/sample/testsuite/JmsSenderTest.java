package com.moby.jms.sample.testsuite;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.moby.jms.sample.JmsSender;

public class JmsSenderTest {

    @Test
    public void testBuildForQueue() {
        try {
            assertNotNull(JmsSender.buildForQueue());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBuildForTopic() {
        try {
            assertNotNull(JmsSender.buildForTopic());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSendString() {
        try {
            JmsSender.buildForQueue().send("TEST : Send");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSendSerializable() {
        ArrayList<String> list = new ArrayList<>();
        list.add("MAKOTO NAKAJIMA");
        try {
            JmsSender.buildForTopic().send(list);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
