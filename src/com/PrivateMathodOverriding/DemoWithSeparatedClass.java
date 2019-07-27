package com.PrivateMathodOverriding;

/*
Private member variables of class A can be accessed (i.e. read/written to) by any method of class A (static or non-static),
thats why Demo will not comiple but OuterClass will do.
 */

class OuterClass {

    private int num;
    private void fun(){
        System.out.println("inside outer class  fun()");
    }


}

class SubClass extends OuterClass{

    private void fun(){
        System.out.println("inside Subclass  fun()");

    }
    public static void main(String[] args) {

        OuterClass obj1 = new SubClass();

        //compiler error as fun() is not accessible
        // obj1.fun();


    }
}
