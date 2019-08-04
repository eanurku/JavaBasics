package com.Multithreading.ExecutorFramework;


import java.util.concurrent.*;

public class ExecutorsWithRunnable {


    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor1= Executors.newSingleThreadExecutor();



        executor1.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {

                    System.out.println(Thread.currentThread() + " i=" + i);
                }
            }
        });

        executor1.submit(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {

                    System.out.println(Thread.currentThread() + " i=" + i);
                }
            }
        });

        executor1.shutdown();
        executor1.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("shutdown executor");




    }
}
