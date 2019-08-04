package com.Multithreading.ExecutorFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ExecutorsRunnableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService executor = Executors.newFixedThreadPool(5);

        Future<?> future = executor.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread() + " i=" + i);
                }
            }
        });

        executor.shutdown();
        System.out.println("shutdown executor");
        Object returnvalue = future.get();
        System.out.println(returnvalue);


    }
}
