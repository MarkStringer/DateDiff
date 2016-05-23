package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DateDiff {
    public static int getDaysBetween(String startDate, String endDate) {
        int[] daysInMonths = {
                31,
                28,
                31,
                30,
                31,
                30,
                31,
                31,
                30,
                31,
                30,
                31
        };

        DateTriple start = parseDate(startDate);
        DateTriple end = parseDate(endDate);
        DateTriple current = new DateTriple(start.day, start.month, start.year);

        int dayCount = 0;

        while (true) {
            current.day++;
            dayCount++;
            if (current.day > (daysInMonths[current.month - 1] + leap(current.year, current.month))) {
                current.month++;

                if (current.month > 12) {
                    current.month = 1;
                    current.year++;
                }
                current.day = 1;
            }

            if ((current.month == end.month)
                    && (current.day == end.day)
                    && (current.year== end.year))
                return dayCount;
        }

    }

    public static int leap(int year, int month)
    {
        if(month!=2)
            return 0;
        else if(isLeapYear(year))
            return 1;
        else
            return 0;
    }


    public static boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        else if (year % 100 == 0)
            return false;
        else
            return(year % 4 == 0);
    }

    public static  DateTriple parseDate(String date) {
        String patternString = "(\\d\\d)/(\\d\\d)/(\\d+)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(date);
        matcher.matches();

        DateTriple triple = new DateTriple(Integer.parseInt(matcher.group(1)),
        Integer.parseInt(matcher.group(2)),
        Integer.parseInt(matcher.group(3)));

        return triple;
    }
}
