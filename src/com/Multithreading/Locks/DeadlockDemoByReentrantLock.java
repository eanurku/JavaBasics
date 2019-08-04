package com.Multithreading.Locks;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
    int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdrawal(int amount) {
        this.balance -= amount;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public static void transferAmount(Account account1, Account account2, int amount) {
        account1.withdrawal(amount);
        account2.deposit(amount);
    }


}

class AmountProcessor {

    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    public  void Process1(Account a1, Account a2) {
        Random rand = new Random();
        for (int i = 1; i <= 100; i++) {

            lock1.lock();
            lock2.lock();
            Account.transferAmount(a1, a2, rand.nextInt(100));
            lock2.unlock();
            lock1.unlock();
        }
    }

    public  void Process2(Account a1, Account a2) {
        Random rand = new Random();
        for (int i = 1; i <= 100; i++) {

            lock2.lock();
            lock1.lock();
            Account.transferAmount(a1, a2, rand.nextInt(100));
            lock1.unlock();
            lock2.unlock();
        }
    }
}

public class DeadlockDemoByReentrantLock {

    public static void main(String[] args) throws InterruptedException {

        Account account1 = new Account(1000);
        Account account2 = new Account(1000);

        AmountProcessor amountproc=new AmountProcessor();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                amountproc.Process1(account1, account2);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                amountproc.Process2(account2, account1);
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("account 1 balance =" + account1.getBalance());
        System.out.println("account 2 balance =" + account2.getBalance());
        System.out.println("total balance =" + (account1.getBalance() + account2.getBalance()));
    }
}
