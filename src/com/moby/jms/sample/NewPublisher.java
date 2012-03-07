package com.moby.jms.sample;

import java.util.ArrayList;


public class NewPublisher {

    private NewPublisher() {}

    public static void main(String[] args)  {
        try {
            JmsSender sender = JmsSender.buildForTopic();
            ArrayList<String> list = new ArrayList<>();
            list.add("I am Object......");
            sender.send(list);
            //sender.send("Say Hello!!!!");
            sender.close();
        } catch(Exception e) {
           e.printStackTrace();
        }
    }
}
