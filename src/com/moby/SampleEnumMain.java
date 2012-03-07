package com.moby;

import java.util.ArrayList;
import java.util.List;

public class SampleEnumMain {

    private static enum Signal {
        green,
        yellow,
        red
    }

    private List<Signal> list = new ArrayList<>();

    private SampleEnumMain() {}

    private void doIt() {
        for (Signal signal: Signal.values()) {
            System.out.println(signal);
            list.add(signal);
        }

        for (Signal s: list)
            System.out.println(s);

    }

    public static void main(String[] args) {
        new SampleEnumMain().doIt();
    }

}
