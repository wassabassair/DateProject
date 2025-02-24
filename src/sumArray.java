import java.util.Scanner;

public class sumArray {


    public static int arraySum(int[] Class) {
        int sum = 0;
        for (int num : Class) {
            sum += num;
        }
        return sum;
    }

    static int[] Class = new int[7];

    public static void main(String[] args) {
        int classNum;
        int moneyAmount;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <= 4; i++) {
                System.out.println("Enter Class: ");
                classNum = sc.nextInt();
                System.out.println("Enter Sum: ");
                moneyAmount = sc.nextInt();
                Class[classNum-1] += moneyAmount;
        }
        System.out.println("Grade Total = " + arraySum(Class));
        //printing classes individual amount
        for (int i = 0; i < Class.length; i++) {
            System.out.println("amount for class number: " + (i+1) + "is: " + Class[i]);
        }
    }
}
