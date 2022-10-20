package com.onepiece.algorithm;

public class InterruptTest extends Thread{

    boolean  stop=false;
    public static void main( String args[] ) throws Exception {
        InterruptTest thread = new InterruptTest();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

    }
    public void run() {
        System.out.println("-------sleeping");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println(Thread.currentThread().isInterrupted());
            e.printStackTrace();
        }
        System.out.println("-------caclulating");
        double d = 0;
        for(int i=1; i<2500000; i++){
            d += Math.E/d;
        }
        System.out.println("-------finish caclulating");

    }
}
