package com.Multithreading.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SampleCounter {
    int count;
    private Lock lock=new ReentrantLock();

    public void increment(){

        count++;
        System.out.println(Thread.currentThread()+" count="+count);
    }
    public void incrementBy(int num){
        for(int i=1;i<=num;i++){
            lock.lock();
            this.increment();
            lock.unlock();
        }
    }
}

public class ReentrantsLockAsReplacementForSynchronised {
    public static void main(String[] args) throws InterruptedException {

        SampleCounter counter=new SampleCounter();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                counter.incrementBy(1000);
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                counter.incrementBy(1000);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("count= "+counter.count);

    }
}
