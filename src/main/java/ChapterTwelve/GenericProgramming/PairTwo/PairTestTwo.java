package ChapterTwelve.GenericProgramming.PairTwo;

import ChapterTwelve.GenericProgramming.PairOne.Pair;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PairTestTwo {
    public static void main(String[] args) {
        GregorianCalendar[] birthdays = {
                new GregorianCalendar(1906, Calendar.DECEMBER, 9),
                new GregorianCalendar(1815, Calendar.DECEMBER, 10),
                new GregorianCalendar(1903, Calendar.DECEMBER, 3),
                new GregorianCalendar(1910, Calendar.JUNE, 22),
        };
        Pair<GregorianCalendar> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + mm.getFirst().getTime());
        System.out.println("max = " + mm.getSecond().getTime());
    }
}
