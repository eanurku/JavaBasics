package com.Multithreading.ExecutorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsWithCallable {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor= Executors.newFixedThreadPool(5);

        executor.submit(new Callable<String>() {
            public String call(){
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread()+" i= "+i);
                }
                return "from callble";
            }
        });
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("shutdown executor");

    }
}
