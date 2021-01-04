package com.harvey.thread.interrupt;

/**
 * @author harvey
 * @date 2020/12/25
 */
public class InterruptAgainTest extends Thread{

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            sleepAction();
        }

        System.out.println("run interrupt");
    }

    public void sleepAction() {

        try {
            System.out.println("begin sleep");
            Thread.sleep(30000);
            System.out.println("end sleep");
        } catch (InterruptedException e) {
            System.out.println("sleep action interrupt");
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new InterruptAgainTest();
        thread.start();
        ;
        Thread.sleep(1000);
        thread.interrupt();
    }
}
