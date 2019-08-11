package com.Multithreading.ProducerConsumer;


import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class QProcessor{


    BlockingQueue<String> bqueue;
    private int SIZE;
    public QProcessor(int SIZE) {
        this.SIZE=SIZE;
        bqueue=new ArrayBlockingQueue<>(SIZE);
    }



    public void producer() throws InterruptedException {

        Random rand =new Random();
        while(true){
            bqueue.put("monu");
            System.out.println((bqueue.size()==SIZE)?"full":"not full");
        }
    }

    public void consumer() throws InterruptedException {

        while(true){

            String val=bqueue.take();
            System.out.println("val ="+val);
        }
    }
}
public class ProducerConsumerByBlockingQueue {

    public static void main(String[] args) {

        QProcessor proc=new QProcessor(10);

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
