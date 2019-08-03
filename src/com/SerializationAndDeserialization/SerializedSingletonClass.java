package com.SerializationAndDeserialization;



import java.io.*;

public class SerializedSingletonClass implements Serializable {

    private static final long serialVersionUID = 1298490234802398L;


     private static class SingleTonHelper {
          private static final  SerializedSingletonClass instance=new SerializedSingletonClass();
    }




    public static SerializedSingletonClass getInstance(){

        return  SingleTonHelper.instance;
    }

    Object readResolve(){
         return getInstance();
    }
}

class Demo{
    public static void main(String[] args) throws Exception {

        SerializedSingletonClass serializedOutObject=SerializedSingletonClass.getInstance();
        FileOutputStream outstream=new FileOutputStream("SerializedSingletonClass.txt");
        ObjectOutputStream outobjstream=new ObjectOutputStream(outstream);
        outobjstream.writeObject(serializedOutObject);


        FileInputStream inputstream=new FileInputStream("SerializedSingletonClass.txt");
        ObjectInputStream inputobjstream=new ObjectInputStream(inputstream);
        SerializedSingletonClass serializedinputObject = (SerializedSingletonClass) inputobjstream.readObject();

        System.out.println(serializedOutObject);
        System.out.println(serializedinputObject);





    }
}
