public class arrayPractice {
    public arrayPractice(Student students[]) {
        int min = 100;
        for (int i = 0; i < students.length; i++) {
            min = Math.min(students[i].getGrade(), min);
        }
        System.out.println(min);
    }
}
