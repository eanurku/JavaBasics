package com.Reflection;


import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;

class SampleClass {

    private String name;
    int num;


    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public SampleClass(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public SampleClass(String name) {
        this(name, 0);
    }


}

public class ReflectionOtherMethods {

    public static void main(String[] args) {

        SampleClass obj=new SampleClass("");

        Class<? extends SampleClass> classobj = obj.getClass();


        Arrays.asList(classobj.getConstructors()).forEach(System.out::println);

        System.out.println();
        Arrays.asList(classobj.getDeclaredFields()).forEach(System.out::println);
        System.out.println();
        Arrays.asList(classobj.getDeclaredMethods()).forEach(System.out::println);

    }
}
