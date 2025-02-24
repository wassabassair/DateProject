public class TesttableTesting {




    public static void main(String[] args) {
        TestTable table = new TestTable();

        //dates
        Date day1 = new Date(5,3,2025);
        Date day2 = new Date(7,3,2025);
        Date day3 = new Date(2,4,2025);
        Date day4 = new Date(17,4,2025);
        Date day5 = new Date(27,4,2025);

        //tests
        Test t1 = new Test("Math",day1,14,2,252 );
        Test t2 = new Test("History",day2,8,2,214);
        Test t3 = new Test("Hebrew",day3,12,1,317);
        Test t4 = new Test("English",day4,10,3,312);
        Test t5 = new Test("Math",day5,8,5,201);


        table.addTest(t1);
        table.addTest(t2);
        table.addTest(t3);
        table.addTest(t4);
        table.addTest(t5);

        System.out.println(table);
    }
}
