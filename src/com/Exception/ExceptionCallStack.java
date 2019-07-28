package com.Exception;

class Student{

    void firstMethod()  {


        System.out.println("start first method");
        try {
            secondMethod();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("end first method");

    }

    void secondMethod() throws Exception {
        System.out.println("start second method");
        thirdMethod();
        System.out.println("end second method");//this will not get executed
    }

    void thirdMethod() throws Exception {
        System.out.println("start third method");
        throw new Exception("this is the message for an exception in third method");

    }
}
public class ExceptionCallStack {

    public static void main(String[] args) {
        Student student=new Student();
        student.firstMethod();
    }


}

