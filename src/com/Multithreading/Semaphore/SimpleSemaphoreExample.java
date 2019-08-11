package com.Multithreading.Semaphore;

import java.util.concurrent.Semaphore;

public class SimpleSemaphoreExample {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphor=new Semaphore(10);
        semaphor.acquire();
        System.out.println("semaphore available permits ="+semaphor.availablePermits());
        semaphor.release();
    }
}
