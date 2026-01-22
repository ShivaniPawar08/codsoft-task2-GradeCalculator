
import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean calculateAgain = true;

        System.out.println(" Student Grade Calculator (Advanced)");

        while (calculateAgain) {

            int subjects;

    
            while (true) {
                System.out.print("\nEnter number of subjects: ");
                if (sc.hasNextInt()) {
                    subjects = sc.nextInt();
                    if (subjects > 0)
                        break;
                } else {
                    sc.next();
                }
                System.out.println(" Enter a valid positive number!");
            }

            int totalMarks = 0;
            int highest = Integer.MIN_VALUE;
            int lowest = Integer.MAX_VALUE;

            int[] marksArr = new int[subjects];

        
            for (int i = 0; i < subjects; i++) {

                int marks;

                while (true) {
                    System.out.print("Enter marks for subject " + (i + 1) + " (0–100): ");
                    if (sc.hasNextInt()) {
                        marks = sc.nextInt();
                        if (marks >= 0 && marks <= 100)
                            break;
                    } else {
                        sc.next();
                    }
                    System.out.println(" Marks must be between 0 and 100!");
                }

                marksArr[i] = marks;
                totalMarks += marks;

                if (marks > highest)
                    highest = marks;
                if (marks < lowest)
                    lowest = marks;
            }

            double average = (double) totalMarks / subjects;

            char grade;
            String description;
            String division;
            boolean passed = average >= 40;

            if (average >= 90) {
                grade = 'A';
                description = "Excellent";
                division = "Distinction";
            } else if (average >= 80) {
                grade = 'B';
                description = "Very Good";
                division = "First Class";
            } else if (average >= 70) {
                grade = 'C';
                description = "Good";
                division = "Second Class";
            } else if (average >= 60) {
                grade = 'D';
                description = "Average";
                division = "Pass Class";
            } else {
                grade = 'F';
                description = "Fail";
                division = "Fail";
            }

            
            System.out.println("\nRESULT");
            System.out.println("-------------------------");
            System.out.println("Total Marks: " + totalMarks);
            System.out.printf("Average Percentage: %.2f%%\n", average);
            System.out.println("Grade: " + grade);
            System.out.println("Performance: " + description);
            System.out.println("Division: " + division);
            System.out.println("Status: " + (passed ? "PASS " : "FAIL "));
            System.out.println("Highest Marks: " + highest);
            System.out.println("Lowest Marks: " + lowest);

            System.out.println("\n Subject-wise Marks:");
            for (int i = 0; i < subjects; i++) {
                System.out.println("Subject " + (i + 1) + ": " + marksArr[i]);
            }


            System.out.print("\nCalculate for another student? (yes/no): ");
            String again = sc.next();

            if (!again.equalsIgnoreCase("yes")) {
                calculateAgain = false;
            }
        }

        sc.close();
        System.out.println("\n Program Ended.");
    }
}
