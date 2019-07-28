package com.Exception;

class TestException extends Exception {

}

public class CustomisedException {
    public static void main(String[] args) {


        try{
            throw new TestException();
        }catch(Exception e){

            System.out.println("handling exception :"+e);
        }finally{
            System.out.println("closing resources");
        }
    }


}
