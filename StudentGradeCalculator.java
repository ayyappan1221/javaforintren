import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of grades:");
        int n = sc.nextInt();

        int[] grades = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter grade " + (i + 1) + ":");
            grades[i] = sc.nextInt();
            sum = sum + grades[i];
        }

        double average = (double) sum / n;

        System.out.println("Average Grade: " + average);

        sc.close();
    }
}
