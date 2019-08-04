package com.Multithreading.Synchronisation;

class Counter {
    int count;

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public synchronized   void  increment() {
        count++;
    }

}

public class SynchronisedMethods {
    public static void main(String[] args) throws InterruptedException {

        Counter counter=new Counter(0);

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    counter.increment();
                }

            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    counter.increment();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("count="+counter.getCount());


    }
}
