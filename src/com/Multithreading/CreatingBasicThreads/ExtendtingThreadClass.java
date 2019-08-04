package com.Multithreading.CreatingBasicThreads;

class Mythread extends Thread{


    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread()+" i= "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ExtendtingThreadClass {

    public static void main(String[] args) {


        Mythread thread1=new Mythread();
        thread1.start();

        Mythread thread2=new Mythread();
        thread2.start();


        System.out.println(Thread.currentThread()+"main thread ends here");
    }
}
