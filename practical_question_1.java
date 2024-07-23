import java.util.Scanner;

public class Marks {
    private static final int NUM_SUBJECTS = 3;
    private static int[][] studentMarks;
    private static int numStudents;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        numStudents = Integer.parseInt(scanner.nextLine());
        studentMarks = new int[numStudents][NUM_SUBJECTS];

        boolean running = true;

        while (running) {
            System.out.println("Enter a command (add, update, average_s, average, total, quit): ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            switch (parts[0]) {
                case "add":
                    addStudent(Integer.parseInt(parts[1]));
                    break;
                case "update":
                    updateStudentMark(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                    break;
                case "average_s":
                    displayAverageMarkForSubject(Integer.parseInt(parts[1]));
                    break;
                case "average":
                    displayAverageMarkForStudent(Integer.parseInt(parts[1]));
                    break;
                case "total":
                    displayTotalMarkForStudent(Integer.parseInt(parts[1]));
                    break;
                case "quit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }
    
    private static void addStudent(int studentID) {
        if (studentID < 1 || studentID > numStudents) {
            System.out.println("Invalid student ID. Must be between 1 and " + numStudents + ".");
        } else if (isStudentAdded(studentID)) {
            System.out.println("Student " + studentID + " already exists.");
        } else {
            for (int i = 0; i < NUM_SUBJECTS; i++) {
                studentMarks[studentID - 1][i] = 0; // Initialize marks to 0
            }
            System.out.println("Student " + studentID + " added.");
        }
    }

    private static boolean isStudentAdded(int studentID) {
        for (int mark : studentMarks[studentID - 1]) {
            if (mark != 0) {
                return true;
            }
        }
        return false;
    }

    private static void updateStudentMark(int studentID, int subjectID, int mark) {
        if (studentID < 1 || studentID > numStudents) {
            System.out.println("Invalid student ID.");
        } else if (subjectID < 1 || subjectID > NUM_SUBJECTS) {
            System.out.println("Invalid subject ID.");
        } else {
            studentMarks[studentID - 1][subjectID - 1] = mark;
            System.out.println("Student " + studentID + "'s marks for subject " + subjectID + " were updated to " + mark);
        }
    }

    private static void displayAverageMarkForSubject(int subjectID) {
        if (subjectID < 1 || subjectID > NUM_SUBJECTS) {
            System.out.println("Invalid subject ID.");
            return;
        }

        int totalMarks = 0;
        int studentCount = 0;
        for (int i = 0; i < numStudents; i++) {
            totalMarks += studentMarks[i][subjectID - 1];
            studentCount++;
        }

        if (studentCount == 0) {
            System.out.println("No students found.");
        } else {
            double average = (double) totalMarks / studentCount;
            System.out.println("The average mark for subject " + subjectID + " is " + average);
        }
    }

    private static void displayAverageMarkForStudent(int studentID) {
        if (studentID < 1 || studentID > numStudents) {
            System.out.println("Student ID not found.");
            return;
        }

        int[] marks = studentMarks[studentID - 1];
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        double average = (double) totalMarks / NUM_SUBJECTS;
        System.out.println("Student " + studentID + " has an average mark of " + average);
    }

    private static void displayTotalMarkForStudent(int studentID) {
        if (studentID < 1 || studentID > numStudents) {
            System.out.println("Student ID not found.");
            return;
        }

        int[] marks = studentMarks[studentID - 1];
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        System.out.println("Student " + studentID + " has a total mark of " + totalMarks);
    }

    private static void displayGrades() {
        System.out.println("Grades:");
        System.out.println("StudentID\tMath\tChem\tPhys");

        for (int i = 0; i < numStudents; i++) {
            System.out.print((i + 1) + "\t\t");
            for (int j = 0; j < NUM_SUBJECTS; j++) {
                System.out.print(getGrade(studentMarks[i][j]) + "\t");
            }
            System.out.println();
        }
    }

}
