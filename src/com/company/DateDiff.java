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

        int startDay;
        int startMonth;
        int startYear;
        int[] startDateTriplet;
        startDateTriplet = parseDate(startDate);
        startDay = startDateTriplet[0];
        startMonth = startDateTriplet[1];
        startYear = startDateTriplet[2];

        int endDay;
        int endMonth;
        int endYear;
        int[] endDateTriplet;
        endDateTriplet = parseDate(endDate);
        endDay = endDateTriplet[0];
        endMonth = endDateTriplet[1];
        endYear = endDateTriplet[2];
        int leap;

        if ((startMonth == endMonth) && (startYear == endYear))
            return endDay - startDay;


        int currentDay = startDay;
        int currentMonth = startMonth;
        int currentYear = startYear;
        int dayCount = 0;
        while (true) {
            if (isLeapYear(currentYear) && (currentMonth == 2)) {
                leap = 1;
            } else {
                leap = 0;
            }
            currentDay++;
            dayCount++;
            if (currentDay > (daysInMonths[currentMonth - 1] + leap)) {
                currentMonth++;

                if (currentMonth > 12) {
                    currentMonth = 1;
                    currentYear++;
                }

                currentDay = 1;
            }

            if ((currentMonth == endMonth)
                    && (currentDay == endDay)
                    && (currentYear==endYear))
                return dayCount;
        }

    }


    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }

        if (year % 4 == 0) {
            return true;
        }

        return false;
    }

    public static int[] parseDate(String date) {
        int[] dateTriplet = new int[3];
        String patternString = "(\\d\\d)/(\\d\\d)/(\\d+)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(date);
        matcher.matches();

        dateTriplet[0] = Integer.parseInt(matcher.group(1));
        dateTriplet[1] = Integer.parseInt(matcher.group(2));
        dateTriplet[2] = Integer.parseInt(matcher.group(3));

        return dateTriplet;
    }
}
