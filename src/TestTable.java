public class TestTable {

    private Test[] tests;
    private int numTests;

    // Default constructor
    public TestTable() {
        tests = new Test[10];
        numTests = 0;
    }

    // Copy constructor
    public TestTable(TestTable other) {
        this.tests = new Test[10];
        //system array copy instead of loop
        System.arraycopy(other.tests, 0, this.tests, 0, other.numTests);
        this.numTests = other.numTests;
    }

    // Get number of tests
    public int getNumTests() {
        return numTests;
    }

    // Get test by index
    public Test getTest(int index) {
        if (index >= 0 && index < numTests) {
            return tests[index];
        }
        return null;
    }

    // Get first test by date
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

    // Get last test by date
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

    // Get tests between dates
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

    // Change test date
    public boolean changeDate(String subject, Date newDate) {
        for (int j = 0; j < numTests; j++) {
            if (tests[j].getDate().equals(newDate)) {
                return false;
            }
        }
        for (int i = 0; i < numTests; i++) {
            if (tests[i].getSubject().equals(subject)) {
                tests[i].setDate(newDate);
                return true;
            }
        }
        return false;
    }

    // Add test
    public boolean addTest(Test t) {
        if (numTests >= tests.length) return false;
        //cant add if full
        for (int i = 0; i < numTests; i++) {
            if (tests[i].getSubject().equals(t.getSubject()) || tests[i].getDate().equals(t.getDate())) {
                return false;
            }
        }
        tests[numTests++] = t;
        return true;
    }

    // Remove test
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

    // Check if friendly
    public boolean isFriendly() {
        if (numTests < 2) return true;
        Test[] sortedTests = new Test[numTests];
        System.arraycopy(tests, 0, sortedTests, 0, numTests);
        for (int i = 0; i < numTests - 1; i++) {
            for (int j = i + 1; j < numTests; j++) {
                if (sortedTests[i].getDate().compareTo(sortedTests[j].getDate()) > 0) {
                    Test temp = sortedTests[i];
                    sortedTests[i] = sortedTests[j];
                    sortedTests[j] = temp;
                }
            }
        }
        for (int i = 1; i < numTests; i++) {
            int diff = sortedTests[i].getDate().daysBetween(sortedTests[i - 1].getDate());
            if (diff < 1) return false; // Less than 1 day
        }
        return true;
    }

    // Average space between tests
    public double averageSpace() {
        if (numTests < 2) return -1;
        Test[] sortedTests = new Test[numTests];
        System.arraycopy(tests, 0, sortedTests, 0, numTests);
        for (int i = 0; i < numTests - 1; i++) {
            for (int j = i + 1; j < numTests; j++) {
                if (sortedTests[i].getDate().compareTo(sortedTests[j].getDate()) > 0) {
                    Test temp = sortedTests[i];
                    sortedTests[i] = sortedTests[j];
                    sortedTests[j] = temp;
                }
            }
        }
        int totalDiff = 0;
        for (int i = 1; i < numTests; i++) {
            totalDiff += sortedTests[i].getDate().daysBetween(sortedTests[i - 1].getDate());
        }
        return totalDiff / (double) (numTests - 1);
    }

    // String representation
    @Override
    public String toString() {
        if (numTests == 0) return "No tests available.";
        Test[] sortedTests = new Test[numTests];
        System.arraycopy(tests, 0, sortedTests, 0, numTests);
        for (int i = 0; i < numTests - 1; i++) {
            for (int j = i + 1; j < numTests; j++) {
                if (sortedTests[i].getDate().compareTo(sortedTests[j].getDate()) > 0) {
                    Test temp = sortedTests[i];
                    sortedTests[i] = sortedTests[j];
                    sortedTests[j] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Test t : sortedTests) {
            sb.append(t.toString()).append("\n");
        }
        return sb.toString();
    }
}
