package com.moby.jms.sample;


public class Receiver {

    private Receiver() {}

    public static void main(String[] args) throws Exception {
        try {
            JmsReceiver receiver = JmsReceiver.buildForQueue();
            System.out.println("Queue Received : " + receiver.receiveString());
            receiver.close();
        } catch(Exception e) {
            throw e;
        }
    }

}
