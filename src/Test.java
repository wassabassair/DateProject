import java.util.Scanner;

public class Test {

    private String Subject;
    private Date date;
    private int startHour;
    private int length;
    private int classNum;
    final private int code;
    static int count = 1;

    public Test(String subject, Date day, int startHour, int length, int classNum) {
        Subject = subject;
        date = day;
        this.startHour = startHour;
        this.length = length;
        this.classNum = classNum;
        this.code = count;
        count++;
    }

    public Test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Subject : ");
        Subject = sc.nextLine();
        System.out.print("Enter Date : d enter m enter y enter");
        Date d = new Date(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.print("Enter startHour : ");
        startHour = sc.nextInt();
        System.out.print("Enter length : ");
        length = sc.nextInt();
        System.out.print("Enter classNum : ");
        classNum = sc.nextInt();
        this.code = count;
        count++;
    }

    public Test(Test other) {
        Subject = other.Subject;
        date = other.date;
        startHour = other.startHour;
        length = other.length;
        classNum = other.classNum;
        code = count;
        count++;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public String getSubject() {
        return Subject;
    }

    public Date getDate() {
        return date;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getLength() {
        return length;
    }

    public int getClassNum() {
        return classNum;
    }

    public int getCode() {
        return code;
    }

    boolean isAtSummer() {
        return (this.date.getMonth() <= 10 && this.date.getMonth() >= 6);
    }

    boolean conflict(Test other) {
        int thisEndHour = this.startHour + this.length;
        int otherEndHour = other.getStartHour() + other.getLength();

        // check if same date and same calss
        if (this.date.equals(other.date) && this.classNum == other.classNum) {
            // check for time overlap
            if (otherEndHour <= this.startHour || thisEndHour <= other.startHour) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("date: %d.%d.%d subject:%s start:%d length:%d class:%d code:%d",
                date.getDay(), date.getMonth(), date.getYear(),
                Subject, startHour, length, classNum, code);
    }
}

