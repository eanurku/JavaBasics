package com.Multithreading.ExecutorFramework;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class process implements Runnable {

    int id;

    public process(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread() + "starting process with id=" + this.id);
        System.out.println(Thread.currentThread() + "finishing process with id=" + this.id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ExecutorFixThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 20; i++) {
            executor.execute(new process(i));
        }
        //shutdown executor so that active threads will die else they will prevent jvm  from shutting down
        executor.shutdown();
        System.out.println("shutdown executor");
        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("main ends here");


    }

}
