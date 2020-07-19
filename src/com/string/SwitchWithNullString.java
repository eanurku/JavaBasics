package com.string;

public class SwitchWithNullString {
    public static void main(String[] args) {
        String name=null;
        //null expression in witch will throw NullPointerException
        switch (name){
            case "anu": System.out.println("case 1");break;
            case "anu1": System.out.println("case 2");break;
            case "anu2": System.out.println("case 3");break;
            case "anu3": System.out.println("case 4");break;
             default:
                 System.out.println("not found");

        }
    }
}
