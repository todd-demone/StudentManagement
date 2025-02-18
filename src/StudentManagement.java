import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class StudentManagement {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("Student Management System");
            System.out.println("1 - Add course");
            System.out.println("2 - Add student");
            System.out.println("3 - Enroll a student in a course");
            System.out.println("4 - Add/update a grade");
            System.out.println("5 - List a student's courses");
            System.out.println("6 - List a course's students");
            System.out.println("7 - Exit the program");
            System.out.print("Enter your choice: ");

            int choice = readInt("Enter your choice: ");
            System.out.println();

            switch (choice) {
                case 1 -> addCourse();
                case 2 -> addStudent();
                case 3 -> enrollStudent();
                case 4 -> setGrade();
                case 5 -> listCourses();
                case 6 -> listStudents();
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addCourse() {
        String courseName = readString("Enter the course name: ");
        String courseCode = readString("Enter the course code: ");

        try {
            courseCode = courseCode.trim().toUpperCase();
            manager.addCourse(new Course(courseName, courseCode));
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addStudent() {
        String name = readString("Enter the student's name: ");
        int id = readInt("Enter the student's ID: ");

        try {
            manager.addStudent(new Student(name, id));
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void enrollStudent() {
        String courseCode = readString("Enter course code: ");
        int studentId = readInt("Enter student ID: ");

        try {
            manager.enrollStudent(courseCode, studentId);
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void setGrade() {
        String courseCode = readString("Enter course code: ");
        int studentId = readInt("Enter student ID: ");

        try {
            manager.setGrade(courseCode, studentId);
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listCourses() {
        int studentId = readInt("Enter student ID: ");

        try {
            Student student = manager.getStudent(studentId);
            Set<Enrollment> enrollments = student.getEnrollments();
            System.out.println(student.getName() + "'s Course List:");
            for (Enrollment enrollment : enrollments) {
                System.out.println("- " + enrollment.getCourse());
            }
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void listStudents() {
        String courseCode = readString("Enter course code: ");

        try {
            Course course = manager.getCourse(courseCode);
            Set<Enrollment> enrollments = course.getEnrollments();
            System.out.println(course.getCourseName() + " - Enrolled Students:");
            for (Enrollment enrollment : enrollments) {
                System.out.println("- " + enrollment.getStudent());
            }
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int readInt(String prompt) {
        int result = 0;
        while (true) {
            System.out.println(prompt);
            try {
                result = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                // If invalid input was placed in the input buffer by scanner.nextInt() (see above), we need
                // scanner.nextLine() to discard that input from the buffer. Otherwise, the input stays there and the
                // loop keeps seeing invalid input and keeps looping indefinitely.
                scanner.nextLine();
            }
        }
        return result;
    }

    private static String readString(String prompt) {
        String result = "";
        while (true) {
            System.out.println(prompt);
            try {
                result = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a string.");
                scanner.nextLine();
            }
        }
        return result;
    }
}