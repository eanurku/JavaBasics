package com.Multithreading.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Processor {
    List<String> list = new ArrayList<>();
    int SIZE;
    Object prodLock = new Object();
    Object consLock = new Object();

    public Processor(int SIZE) {
        this.SIZE = SIZE;
    }


    public void producer() throws InterruptedException {

        Random rand = new Random();

        Thread.sleep(5000);
        while (true) {

            synchronized (this) {
                while (list.size() == SIZE) {
                    this.wait();
                }
                list.add("monu :" + rand.nextInt(100));
                System.out.println("list size=" + list.size());

                this.notifyAll();

            }
        }

    }

    public void consumer() throws InterruptedException {

        while (true) {

            synchronized (this) {


                while (list.size() == 0) {
                    System.out.println("list empty so wait");
                    this.wait();
                }
                String value = list.remove(0);
                System.out.println("consumed value: " + value);
                if (list.size() == 0) {
                    System.out.println("list is empty so notify()");
                    this.notifyAll();
                }
            }
        }

    }
}

public class ProducerConsumerByWaitAndNotify {


    public static void main(String[] args) {

        Processor proc = new Processor(10);

        Thread prod = new Thread() {
            public void run() {

                try {
                    proc.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread cons = new Thread() {
            public void run() {

                try {
                    proc.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        prod.start();
        cons.start();

    }
}
