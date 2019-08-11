package com.Multithreading.Locks;


import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockHandlingByReentrantLock {

    static class Account {

        int balance;

        public int getBalance() {
            return balance;
        }

        public Account(int balance) {
            this.balance = balance;
        }

        public void deposit(int amount) {
            this.balance += amount;
        }

        public void withdraw(int amount) {
            this.balance -= amount;
        }
        public static void transfer(Account a1,Account a2,int amount){
            a1.balance-=amount;
            a2.balance+=amount;
        }
    }

    static class AmountTransfer{
        Account a1;
        Account a2;
        Lock lock1=new ReentrantLock();
        Lock lock2=new ReentrantLock();

        Random rand =new Random();

        public AmountTransfer(Account a1, Account a2) {
            this.a1 = a1;
            this.a2 = a2;
        }

        public void process1() throws InterruptedException {
            for(int i=1;i<=1000;i++){

               acquireLocks(lock1,lock2);

                Account.transfer(a1,a2,rand.nextInt(100));

                lock1.unlock();
                lock2.unlock();
            }
        }
        public void process2() throws InterruptedException {
            for(int i=1;i<=1000;i++){

                acquireLocks(lock1,lock2);
                Account.transfer(a1,a2,rand.nextInt(100));

                lock1.unlock();
                lock2.unlock();
            }
        }

        private void acquireLocks(Lock lock1, Lock lock2) {

            boolean lock1Aquired=false;
            boolean lock2Acquired=false;
            while(true) {
                try {
                    lock1Aquired = lock1.tryLock();
                    lock2Acquired = lock2.tryLock();
                } finally {
                    if(lock1Aquired && lock2Acquired)
                        return;

                    if (lock1Aquired) {
                        lock1.unlock();

                    }
                    if (lock2Acquired) {
                        lock2.unlock();

                    }
                }
            }


        }
    }
    public static void main(String[] args) throws InterruptedException {


        Account firstAccount = new Account(1000);
        Account secondAccount = new Account(1000);

        AmountTransfer transferProc=new AmountTransfer(firstAccount,secondAccount);

        Thread t1 = new Thread() {
            public void run() {
                try {
                    transferProc.process1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                try {
                    transferProc.process2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("first account balalce:"+firstAccount.getBalance());
        System.out.println("second account balance:"+secondAccount.getBalance());
        System.out.println("total balance:"+(secondAccount.getBalance()+firstAccount.getBalance()));


    }
}
