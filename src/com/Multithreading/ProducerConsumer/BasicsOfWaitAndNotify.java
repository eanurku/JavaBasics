package com.Multithreading.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class SampleProcr{

    public synchronized  void producer() throws InterruptedException {

        System.out.println("producer started...");
        this.wait();
        System.out.println("producer stopped.");
    }
    public synchronized void consumer() throws InterruptedException {

        Thread.sleep(3000);
        System.out.println("consumer started...");
        this.notify();
        Thread.sleep(3000);
        System.out.println("consumer stopped.");
    }

}

public class BasicsOfWaitAndNotify {



    public static void main(String[] args) {

        SampleProcr proc=new SampleProcr();

        Thread prod=new Thread(){
            public void run(){
                try {
                    proc.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread cons=new Thread(){
            public void run(){

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
