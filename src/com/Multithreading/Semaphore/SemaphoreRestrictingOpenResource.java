package com.Multithreading.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


class DBConnection{

    Semaphore semaphore=new Semaphore(5);
    int count=0;
    public void connect() throws InterruptedException {

        semaphore.acquire();
        synchronized (this){
            count++;
            System.out.println(Thread.currentThread()+" count="+count);

        //-------
        //open a db connection
        //-----------
        //close DB connection

        }
        Thread.sleep(1000);
        synchronized (this){
            count--;

        }
        semaphore.release();
    }
}
public class SemaphoreRestrictingOpenResource {


    public static void main(String[] args) {


        ExecutorService executor= Executors.newFixedThreadPool(10);
        DBConnection conn=new DBConnection();
        for(int i=0;i<20;i++){

            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        conn.connect();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        executor.shutdown();
    }
}
