package com.falah.test;


import com.pi4j.Pi4J;

public class RelayControl implements Runnable {

    public void run() {
        final var gpio = Pi4J.newAutoContext();

        final var pin21 = gpio.digitalOutput().create(21);
        final var pin26 = gpio.digitalOutput().create(26);
        try {
            while (true) {
                pin21.high();
                pin26.high();
                System.out.print("Pin 21: " + pin21.state());
                System.out.println("\t Pin 26: " + pin26.state());
                Thread.sleep(1000);

                pin21.low();
                pin26.low();
                System.out.print("Pin 21: " + pin21.state());
                System.out.println("\t Pin 26: " + pin26.state());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pin21.low();
            pin26.low();
            gpio.shutdown();
        }
    }
}
