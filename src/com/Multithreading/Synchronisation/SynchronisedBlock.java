package com.Multithreading.Synchronisation;


import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

class CreateListData {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    Object obj1=new Object();
    Object obj2=new Object();

    public void addToList1(Integer num) {
        synchronized (obj1) {
            list1.add(num);
        }
    }

    public void addToList2(Integer num) {
        synchronized (obj2) {
            list2.add(num);
        }
    }


    public void process() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            Thread.sleep(10);
            addToList1(i);
            addToList2(i);
        }
    }
}

public class SynchronisedBlock {

    public static void main(String[] args) throws InterruptedException {

        CreateListData listdata = new CreateListData();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    listdata.process();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    listdata.process();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("list size=" + listdata.list1.size());
        System.out.println("list2 size=" + listdata.list1.size());
    }
}
