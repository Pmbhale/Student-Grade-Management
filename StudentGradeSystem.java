import java.util.ArrayList;
import java.util.Scanner;

// Student class (Encapsulation + OOP)
class Student {
    private String name;
    private int[] marks;

    // Constructor
    public Student(String name, int subjects) {
        this.name = name;
        this.marks = new int[subjects];
    }

    // Input marks
    public void setMarks(Scanner sc) {
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    // Calculate average
    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.length;
    }

    // Assign Grade
    public String getGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 50) return "C";
        else return "Fail";
    }

    // Display student info
    public void displayInfo() {
        System.out.println("Name: " + name +
                " | Average: " + calculateAverage() +
                " | Grade: " + getGrade());
    }
}

// Main System Class
public class StudentGradeSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);
    }

    // Add new student
    private static void addStudent() {
        sc.nextLine(); // consume newline
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        Student s = new Student(name, subjects);
        s.setMarks(sc);
        students.add(s);

        System.out.println("✅ Student added successfully!");
    }

    // Display all students
    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found!");
        } else {
            System.out.println("\n--- Student Records ---");
            for (Student s : students) {
                s.displayInfo();
            }
        }
    }
}
