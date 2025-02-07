public class arrayPractice {
    public double arrayPractice(student[] students) {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getSubject().String.equals("Math")) {
                sum += students[i].getGrade();
                count++;
            }
            if (count != 0) return (sum/count);
            else return 0;
        }
    }
}
