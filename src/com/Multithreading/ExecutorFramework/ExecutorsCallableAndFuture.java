package com.Multithreading.ExecutorFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Employee {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class ExecutorsCallableAndFuture {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Employee> emplist=new ArrayList<>();

        Future future=executor.submit(new Callable<List<Employee> >() {

            public List<Employee> call() throws InterruptedException {
                for (int i = 0; i < 3; i++) {
                    emplist.add(new Employee(i,"name"+i));
                    Thread.sleep(10000);
                }

                return emplist;
            }
        });

        executor.shutdown();
        System.out.println("shutting executor");

        List<Employee> returnlist = (List<Employee>)future.get();
        returnlist.forEach(s-> System.out.println(s.getName()));

    }
}
