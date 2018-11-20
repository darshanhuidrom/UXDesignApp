package com.globizs.uxdesignapp.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalenderCaculator {


    public static int getNoOfDaysInMonth(int iYear, int iMonth, int iDay) {
        Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);
        int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
        return daysInMonth;
    }

    public static int getCurrentMonthNoOfDays() {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd");
        String formattedDate = df.format(c);
        int day = Integer.parseInt(formattedDate);
        return getNoOfDaysInMonth(year, month, day);
    }

    public static int getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        return month;
    }

    public static int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

    public static int getCurrentDate() {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd");
        String formattedDate = df.format(c);
        int day = Integer.parseInt(formattedDate);
        return day;
    }

    public static int getDayOfWeekOfCurrent(){
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    public static int firstDayOfTheMonth() {
        Calendar calendar = Calendar.getInstance();
        int firstDay = calendar.getActualMinimum(Calendar.DATE);
        calendar.set(Calendar.DATE, firstDay);
        int firstDayInt = calendar.get(Calendar.DAY_OF_WEEK);
        return firstDayInt;
    }

    public static int firstDayOfTheMonth(int iYear, int iMonth, int iDay) {
        Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);
        int firstDay = mycal.getActualMinimum(Calendar.DATE);
        mycal.set(Calendar.DATE, firstDay);
        int firstDayInt = mycal.get(Calendar.DAY_OF_WEEK);
        return firstDayInt;
    }

    public static int lastDayOfTheMonth() {
        Calendar calendar = Calendar.getInstance();
        int lastDate = calendar.getActualMaximum(Calendar.DATE);
        calendar.set(Calendar.DATE, lastDate);
        int lastDay = calendar.get(Calendar.DAY_OF_WEEK);
        return lastDay;
    }

    public static int getCurrentDayOfWeek(int iYear,int iMonth ,int iDay){
        Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);
        int currentDayOfWeek = mycal.get(Calendar.DAY_OF_WEEK);
        return currentDayOfWeek;
    }


}
