public class arrayPractice {
    public double arrayPractice(student[] students) {
        Student s = null;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getSubject().String.equals("Math")) {
                sum += students[i].getGrade();
                count++;
            }
            return (sum/count);
        }
    }
}
