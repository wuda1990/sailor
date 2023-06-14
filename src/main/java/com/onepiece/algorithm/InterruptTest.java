package com.onepiece.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterruptTest extends Thread {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    boolean stop = false;

    public static void main(String args[]) throws Exception {
        InterruptTest thread = new InterruptTest();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

    }

    public void run() {
        log.info("-------sleeping");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.info("status:{}", Thread.currentThread().interrupted());
            log.info("status:{}", Thread.currentThread().interrupted());
            log.error("interrupted", e);
        }
        log.info("-------caclulating");
        double d = 0;
        for (int i = 1; i < 2500000; i++) {
            d += Math.E / d;
//            System.out.println("1");
        }
        log.info("-------finish caclulating");

    }
}
