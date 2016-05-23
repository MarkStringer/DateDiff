package com.company;

/**
 * Created by marks on 22/05/2016.
 */
public class DateTriple {

    public int day;
    public int month;
    public int year;

    public DateTriple(int newDay, int newMonth, int newYear)
    {
        day=newDay;
        month=newMonth;
        year=newYear;
    }

    public static int compare(DateTriple a, DateTriple b)
    {
        if(a.year < b.year)
            return 1;

        if(a.year > b.year)
            return -1;

        if(a.month < b.month)
            return 1;

        
        if(a.month > b.month)
            return -1;

        if(a.day < b.day)
            return 1;

        if(a.day > b.day)
            return -1;

        return 0;
    }
}
