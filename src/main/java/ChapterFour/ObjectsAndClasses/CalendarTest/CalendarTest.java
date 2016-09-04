package ChapterFour.ObjectsAndClasses.CalendarTest;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String[] args) {
        //to build the objects d on the current date
        GregorianCalendar d = new GregorianCalendar();
        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);
        //to set the object d at the beginning of the month
        d.set(Calendar.DAY_OF_MONTH, 1);
        int weekday = d.get(Calendar.DAY_OF_WEEK);
        //to the first day of the week(Sunday in the United States)
        int firstDayOfWeek = d.getFirstDayOfWeek();
        //to determine the required indent in the first line
        int indent = 0;
        while (weekday != firstDayOfWeek) {
            indent++;
            d.add(Calendar.DAY_OF_MONTH, -1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }
        //display the names of the days of the week
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%4s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }
        while (weekday != firstDayOfWeek);
        System.out.println();
        for (int i = 1; i <= indent; i++)
            System.out.print(" ");
        d.set(Calendar.DAY_OF_MONTH, 1);
        do {
            //display the day of the week
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day);
            //to mark the current day flag *
            if (day == today)
                System.out.print("*");
            else
                System.out.print(" ");
            //move the object d to the next day
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
            //start next week with a new line
            if (weekday == firstDayOfWeek)
                System.out.println();
        }
        while (d.get(Calendar.MONTH) == month);
        //to complete the cycle, when the object is set
        //to the first day of the following month

        //move the string if required
        if (weekday != firstDayOfWeek)
            System.out.println();
    }
}
