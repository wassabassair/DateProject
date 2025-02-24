import java.util.Scanner;

public class Shoe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numDays = 6;
        int numStores = 5;
        int[][] dailyStoreRevenue = new int[numDays][numStores]; // rows: days, columns: stores
        int[] dayTotals = new int[numDays];

        for (int day = 0; day < numDays; day++) {
            System.out.println("Entering revenue for Day " + (day + 1) + ":");
            while (true) {
                System.out.println("Enter store number (1-" + numStores + ", or 0 to finish the day):");
                int storeNum = sc.nextInt();
                if (storeNum == 0) break;
                if (storeNum < 1 || storeNum > numStores) {
                    System.out.println("Please enter a valid store number between 1 and " + numStores);
                    continue;
                }
                System.out.println("Enter price for store " + storeNum + ":");
                int price = sc.nextInt();
                dailyStoreRevenue[day][storeNum - 1] += price;
                dayTotals[day] += price;
            }
        }

        // Display the results for each day and each store
        for (int day = 0; day < numDays; day++) {
            System.out.println("\nDay " + (day + 1) + " Total Revenue: " + dayTotals[day]);
            for (int store = 0; store < numStores; store++) {
                System.out.println("  Store " + (store + 1) + " Revenue: " + dailyStoreRevenue[day][store]);
            }
        }
        sc.close();
    }
}