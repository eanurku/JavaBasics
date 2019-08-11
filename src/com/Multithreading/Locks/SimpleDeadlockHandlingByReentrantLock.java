package com.Multithreading.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//keep locks in order to avoid deadlock
public class SimpleDeadlockHandlingByReentrantLock {


    static class Processor {

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        private int count;

        public int getCount() {
            return count;
        }

        public Processor(int count) {
            this.count = count;
        }

        private void increment() {

            count++;
        }

        public void process1() {
            for (int i = 1; i <= 1000; i++) {

                lock1.lock();
                lock2.lock();
                increment();
                lock2.unlock();
                lock1.unlock();
            }

        }

        public void process2() {
            for (int i = 1; i <= 1000; i++) {
                lock1.lock();
                lock2.lock();

                increment();
                lock2.unlock();
                lock1.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {

        Processor proc = new Processor(0);

        Thread t1 = new Thread() {
            public void run() {

                proc.process1();
            }
        };
        Thread t2 = new Thread() {
            public void run() {

                proc.process2();
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count=" + proc.getCount());
    }
}
