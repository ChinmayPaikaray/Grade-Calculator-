import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numSubjects = 0;
        // Ask user how many subjects with validation
        while (true) {
            System.out.print("Enter the number of subjects: ");
            if (scanner.hasNextInt()) {
                numSubjects = scanner.nextInt();
                if (numSubjects > 0) break;
                else System.out.println("Number of subjects must be positive.");
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // consume the invalid token
            }
        }

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
                if (scanner.hasNextInt()) {
                    int mark = scanner.nextInt();
                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        totalMarks += mark;
                        break;
                    } else {
                        System.out.println("Marks must be between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // consume invalid input
                }
            }
        }

        // Calculate average percentage
        double average = (double) totalMarks / numSubjects;

        // Determine grade
        char grade;
        if (average >= 90) grade = 'A';
        else if (average >= 80) grade = 'B';
        else if (average >= 70) grade = 'C';
        else if (average >= 60) grade = 'D';
        else grade = 'F';

        // Display results
        System.out.println("\n--- Result ---");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

