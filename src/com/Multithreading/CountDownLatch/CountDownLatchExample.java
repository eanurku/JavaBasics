package com.Multithreading.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {


        CountDownLatch latch = new CountDownLatch(3);
        Thread t1 = new Thread() {

            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println(Thread.currentThread() + "i=" + i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                latch.countDown();
            }
        };

        Thread t2 = new Thread() {

            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println(Thread.currentThread() + "i=" + i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                latch.countDown();
            }
        };

        Thread t3 = new Thread() {

            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println(Thread.currentThread() + "i=" + i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                latch.countDown();
            }
        };

        t1.start();
        t2.start();
        t3.start();

        latch.await();//block the current thread untill latch count==0
        System.out.println("Continue main thread after all threads processed");

    }
}
