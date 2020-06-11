package com.Multithreading.ThreadClassMethodsDetails;

public class YieldMethod {
    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(){
          public void run(){
              for(int i=0;i<=100;i++){
                  System.out.println("running in "+Thread.currentThread());
                  try {
                      Thread.sleep(100);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  this.yield();
              }
          }
        };

        Thread t2=new Thread(){
            public void run(){
                for(int i=0;i<=100;i++){
                    System.out.println("running in "+Thread.currentThread());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        t1.setName("first thread");
        t2.setName("second thread");
        t2.setPriority(4);
        System.out.println("t1 priority:"+t1.getPriority());
        System.out.println("t2 priority:"+t2.getPriority());

        t1.start();
        t2.start();
        t1.join();
        t2.join();


    }
}
