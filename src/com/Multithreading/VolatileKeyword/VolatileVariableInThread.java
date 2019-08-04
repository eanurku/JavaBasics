package com.Multithreading.VolatileKeyword;

import java.util.Scanner;
/*
volatile keyword keeps variable updated across all thread and
threads will have latest view of variable value
 */

class SampleThread extends Thread {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running thread");
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class VolatileVariableInThread {
    public static void main(String[] args) throws InterruptedException {

        SampleThread thread1 = new SampleThread();

        thread1.start();
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        thread1.shutdown();
    }
}
