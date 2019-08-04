package com.Multithreading.Interrupt;

import java.util.concurrent.ExecutorService;

public class IsInterruptedMethod {

    public static void main(String[] args) throws InterruptedException {


        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    System.out.println("i="+i);
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("this thread is interrupted :"+Thread.currentThread().isInterrupted());
                        break;
                    }

                }
            }
        });

        thread1.start();
        Thread.sleep(1);
        thread1.interrupt();
        thread1.join();
        System.out.println("interrupting the thread1");

    }
}
