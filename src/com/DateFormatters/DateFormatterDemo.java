package com.DateFormatters;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatterDemo {


    public static void main(String[] args) {
        Date date = new Date();


        DateFormat dateformatter = DateFormat.getDateInstance(DateFormat.SHORT, Locale.UK);
        System.out.println(dateformatter.format(date));


        DateFormat timeformatter = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.UK);
        System.out.println(timeformatter.format(date));

        DateFormat datetimeformatter = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG, Locale.UK);
        System.out.println(datetimeformatter.format(date));


    }


}
