package com.moby.jms.sample;


public class NewSender {

    private  NewSender() {}

    public static void main(String[] args) {
        try {
            JmsSender sender = JmsSender.buildForQueue();
            sender.send("Hi ! WORLD!!!!");
            sender.close();
        } catch(Exception e) {
           e.printStackTrace();
        }
    }
}
