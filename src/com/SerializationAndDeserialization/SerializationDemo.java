package com.SerializationAndDeserialization;


import java.io.*;

class Student implements Serializable{

    String name;
    int rollno;

    public String getName() {
        return name;
    }

    public int getRollno() {
        return rollno;
    }


    public Student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }

}
public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student sobj = new Student("anurag kumar", 12);


        FileOutputStream out=new FileOutputStream("testfile.txt");
        ObjectOutputStream outobj=new ObjectOutputStream(out);
        outobj.writeObject(sobj);


        FileInputStream input=new FileInputStream("testfile.txt");
        ObjectInputStream inobj=new ObjectInputStream(input);
        Student desobj = (Student)inobj.readObject();
        System.out.println(desobj.getName()+" "+desobj.getRollno());


    }
}
