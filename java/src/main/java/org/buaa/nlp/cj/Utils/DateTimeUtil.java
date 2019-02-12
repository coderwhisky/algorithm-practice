package org.buaa.nlp.cj.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by whisky on 15-4-20.
 */
public class DateTimeUtil {

    public static int daysBetween(String smdate,String bdate){
        long time1 = 0;
        long time2 = 0;

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(smdate));
            time1= cal.getTimeInMillis();
            cal.setTime(sdf.parse(bdate));
            time2 = cal.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static int daysBetween(Date smdate, Date bdate) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            smdate=sdf.parse(sdf.format(smdate));
            bdate=sdf.parse(sdf.format(bdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static long secondsOf(String date) {
        long seconds = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        try {
            cal.setTime(sdf.parse(date));
            seconds = cal.getTimeInMillis() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return seconds;
    }

    public static long secondsOf(Date date) {
        long seconds = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        Calendar cal = Calendar.getInstance();
        try {
            date = sdf.parse(sdf.format(date));
            cal.setTime(date);
            seconds = cal.getTimeInMillis() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return seconds;
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("****" + DateTimeUtil.secondsOf("2015-04-20"));
    }

}
