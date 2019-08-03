package com.DateFormatters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatter {

    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        System.out.println(date);


        SimpleDateFormat formattter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String dateString = formattter.format(date);
        System.out.println(dateString);

        Date newdate = formattter.parse(dateString);
        System.out.println(newdate.toString());

    }
}
