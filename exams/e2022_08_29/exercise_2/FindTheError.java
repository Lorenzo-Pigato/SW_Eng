package exams.e2022_08_29.exercise_2;

public class FindTheError {
    public static void main(String[] args) {
        DayDate d1 = new DayDate(22);
        DayDate d2 = new DayMonthDate(26, 3);
        DayMonthDate d3 = new DayMonthDate(14, 9);
        Date d4 = new DayMonthDate(12, 5);
        DayMonthYearDate d5 = new DayMonthYearDate(18, 4, 2021);
        //Date d6 = new Date(8);
        System.out.println("06: " + d1.dateDistance(d2));
        System.out.println("07: " + d1.dateDistance(d3));
        //System.out.println(d1.dateDistance(d6));
        System.out.println("09 " + d2.dateDistance(d3));
        System.out.println("10 " + d3.dateDistance(d2));
        System.out.println("11 " + d3.dateDistance(d5));
        System.out.println("12 " + d4.dateDistance(d5));
        System.out.println("13 " + d5.dateDistance(d3));
        //System.out.println(d5.dateDistance(d6));
    }
}

abstract class Date {
    public abstract String dateDistance(Date d);
}

class DayDate extends Date {
    int day;

    public String dateDistance(Date p) {
        return dateDistance((DayDate) p);
    }

    public String dateDistance(DayDate p) {
        return (day - p.day) + " days";
    }

    public DayDate(int d) {
        day = d;
    }
}

class DayMonthDate extends DayDate {
    int month;

    DayMonthDate(int d, int m) {
        super(d);
        month = m;
    }

    public String dateDistance(Date p) {
        return dateDistance((DayMonthDate) p);
    }

    public String dateDistance(DayMonthDate p) {
        return super.dateDistance(p) + ": " + (month - p.month) + " months";
    }
}

class DayMonthYearDate extends DayMonthDate {
    int year;

    DayMonthYearDate(int d, int m, int y) {
        super(d, m);
        year = y;
    }

    public String dateDistance(Date p) {
        return dateDistance((DayMonthYearDate) p);
    }

    public String dateDistance(DayMonthYearDate p) {
        return super.dateDistance(p) + ": " + (year - p.year) + " years";
    }
}