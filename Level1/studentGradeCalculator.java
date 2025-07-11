import java.util.Scanner;

public class studentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of grades: ");
        int numberOfGrades = scanner.nextInt();

        if (numberOfGrades <= 0) {
            System.out.println("Number of grades must be positive.");
            return;
        }

        double[] gradeArray = new double[numberOfGrades];
        for (int i = 0; i < numberOfGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            double grade = scanner.nextDouble();

            if (grade < 0 || grade > 100) {
                System.out.println("Grade must be between 0 and 100.");
                i--;
            } else {
                gradeArray[i] = grade;
            }
        }
        
        double sum = 0;
        for (double grade : gradeArray) {
            sum += grade;
        }

        double average = sum / numberOfGrades;
        System.out.printf("\nThe average grade is: %.2f\n", average);
        scanner.close();
    }
}
