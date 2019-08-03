package com.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Teacher {

    private String name;

    public String getName() {
        return name;
    }
}

class Student {

    String name;
    String city;

    public Student(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

}

public class ReflectionCreatingObjects {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {


        //creating object by Class.newInstance which calls no arg constructor so
        // Teacher class should have no arg constructor

        Class<?> tclassobj = Class.forName("com.Reflection.Teacher");
        Teacher obj1 = (Teacher)tclassobj.newInstance();
        System.out.println(obj1.getName());



        //creating object with argument using Constructor.newInstance method

        Class<?> sclassobj = Class.forName("com.Reflection.Student");
        Constructor<?> sconsobj = sclassobj.getConstructor(String.class, String.class);
        Student studentObj = (Student) sconsobj.newInstance("gonu", "patna");

        System.out.println(studentObj.getName()+" "+studentObj.getCity());



    }
}
