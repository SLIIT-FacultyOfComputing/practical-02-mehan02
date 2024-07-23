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
            System.out.println("Enter a command (add, update, average_s, average, total, grades, quit): ");
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
                case "grades":
                    displayGrades();
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
