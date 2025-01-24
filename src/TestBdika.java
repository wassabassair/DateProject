public class TestBdika {
    public static void main(String[] args) {
        Date date1 = new Date(12,3,2025);
        Test test1 = new Test("Math",date1,10,2,232);

        Date date2 = new Date(12,3,2025);
        Test test2 = new Test("Math",date2,11,4,232);

        System.out.println(test1.conflict(test2));
    }
}
