package com.intuit.cg.backendtechassessment.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CalUtil {

    public static java.util.Date convert(String s)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        java.util.Date date = null;

        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static String convert(Date date)
    {
        java.util.Date tdate = new java.util.Date(date.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(tdate);
    }


}
