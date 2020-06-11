package com.string;

public class StringDemo {

    public static void main(String[] args) {

        String s2=new String("abc");
        String s1="abc";
        String s3=s1;
        String s4=s1+s2;


        System.out.println(s1==s2);
        System.out.println(s1==s3);

        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode("abc"));
        System.out.println(System.identityHashCode(s3));

        s2=s2.intern();
        System.out.println(s1==s2);
        System.out.println(s1==s3);




    }
}
