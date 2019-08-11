package com.Multithreading.ThreadClassMethodsDetails;

public class JoinMethod {
    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(){
            public void run(){
                for(int i=1;i<=100;i++){
                    System.out.println(Thread.currentThread()+"i="+i);
                }
            }
        };

        t1.start();
        System.out.println("join call block the current thread untill calling thread gets completed");
        t1.join();
        System.out.println("main ends here");
    }
}
