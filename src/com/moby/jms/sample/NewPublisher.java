package com.moby.jms.sample;


public class NewPublisher {

    private NewPublisher() {}

    public static void main(String[] args)  {
        try {
            JmsSender sender = JmsSender.buildForTopic();
            sender.send("Say Hello!!!!");
            sender.close();
        } catch(Exception e) {
           e.printStackTrace();
        }
    }
}
