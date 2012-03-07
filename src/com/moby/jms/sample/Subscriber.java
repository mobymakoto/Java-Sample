package com.moby.jms.sample;


public class Subscriber {

    private Subscriber() {}

    public static void main(String[] args) throws Exception {
        try {
            JmsReceiver receiver = JmsReceiver.buildForTopic();
            System.out.println("Topic Received : " + receiver.receiveString());
            receiver.close();
        } catch(Exception e) {
            throw e;
        }
    }

}
