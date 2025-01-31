public class TestTable {

    private Test[] tests;
    private int numTests;


    public TestTable() {
        tests = new Test[10];
        numTests = 0;
    }


    public TestTable(TestTable other) {
        this.tests = new Test[10];
        System.arraycopy(other.tests, 0, this.tests, 0, other.numTests);
        this.numTests = other.numTests;
    }


    public int getNumTests() {
        return numTests;
    }


    public Test getTest(int index) {
        if (index >= 0 && index < numTests) {
            return tests[index];
        }
        return null;
    }


    public Test first() {
        if (numTests == 0) return null;
        Test earliest = tests[0];
        for (int i = 1; i < numTests; i++) {
            if (tests[i].getDate().compareTo(earliest.getDate()) < 0) {
                earliest = tests[i];
            }
        }
        return earliest;
    }


    public Test last() {
        if (numTests == 0) return null;
        Test latest = tests[0];
        for (int i = 1; i < numTests; i++) {
            if (tests[i].getDate().compareTo(latest.getDate()) > 0) {
                latest = tests[i];
            }
        }
        return latest;
    }


    public Test[] getTestsBetween(Date start, Date end) {
        Test[] betweenTests = new Test[numTests];
        int count = 0;
        for (int i = 0; i < numTests; i++) {
            Date testDate = tests[i].getDate();
            if (testDate.compareTo(start) >= 0 && testDate.compareTo(end) <= 0) {
                betweenTests[count++] = tests[i];
            }
        }
        if (count == 0) return null;
        Test[] result = new Test[count];
        System.arraycopy(betweenTests, 0, result, 0, count);
        return result;
    }


    public boolean changeDate(String subject, Date newDate) {
        for (int i = 0; i < numTests; i++) {
            if (tests[i].getSubject().equals(subject)) {
                for (int j = 0; j < numTests; j++) {
                    if (tests[j].getDate().equals(newDate)) {
                        return false;
                    }
                }
                tests[i].setDate(newDate);
                return true;
            }
        }
        return false;
    }


    public boolean addTest(Test t) {
        if (numTests >= tests.length) return false;
        for (int i = 0; i < numTests; i++) {
            if (tests[i].getSubject().equals(t.getSubject()) || tests[i].getDate().equals(t.getDate())) {
                return false;
            }
        }
        tests[numTests++] = t;
        return true;
    }


    public Test removeTest(String subject) {
        for (int i = 0; i < numTests; i++) {
            if (tests[i].getSubject().equals(subject)) {
                Test removed = tests[i];
                tests[i] = tests[--numTests];
                tests[numTests] = null;
                return removed;
            }
        }
        return null;
    }
}