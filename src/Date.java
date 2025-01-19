import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Date {
    private int day;
    private int month;
    private int year;
    private static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter day:");
        this.day = sc.nextInt();
        System.out.println("Enter month:");
        this.month = sc.nextInt();
        System.out.println("Enter year:");
        this.year = sc.nextInt();
    }

    public Date(Date other) {
        this.day = other.getDay();
        this.month = other.getMonth();
        this.year = other.getYear();
    }

    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }
    public int getMonth() {
        return this.month;
    }
    public int getDay() {
        return this.day;
    }
    public int daysInYear() {
        if (this.year % 4 == 0) return 366;
        else return 365;
    }
    public boolean isInteresting() {
        int lastTwoDigitsOfYear = this.year % 100; // take las t2

        int lastDigitOfYear = this.year % 10; // take last digit of

        if (this.day == this.month) {
            if (this.day < 10) { // one mnuber

                return this.day == lastDigitOfYear;
            } else { // 2 numbers
                return this.day == lastTwoDigitsOfYear;
            }
        }
        return false;
    }

    public int daysPass( )
    {
        int numDays = 0;
        for(int i = 0; i <= this.month-2; i++)
        {
            numDays += daysInMonth[i];
        }
        numDays += this.day;
        if(this.year%4 == 0 && this.month > 2)
            numDays++;
        return numDays;
    }

    int daysLeft() {
        return daysInYear()-daysPass();
    }

    boolean equals(Date other) {
        return (this.day == other.day) && (this.month == other.month) && (this.year == other.year);
    }

    public int compareTo(Date other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        } else if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        } else {
            return Integer.compare(this.day, other.day);
        }
    }

    public Date next() {
        LocalDate thisDate = LocalDate.of(this.year, this.month, this.day);
        LocalDate nextDate = thisDate.plusDays(1);
        return new Date(nextDate.getDayOfMonth(), nextDate.getMonthValue(), nextDate.getYear());
    }

    public int daysBetween(Date other) {
        LocalDate thisDate = LocalDate.of(this.year, this.month, this.day);
        LocalDate otherDate = LocalDate.of(other.getYear(), other.getMonth(), other.getDay());
        return (int) ChronoUnit.DAYS.between(thisDate, otherDate);
    }

    public String toString() {
        return String.format("%d/%d/%d", day, month, year);
    }
}