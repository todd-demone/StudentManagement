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

            int choice = scanner.nextInt();
            scanner.nextLine();

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
        System.out.print("Enter the course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter the course code: ");
        String courseCode = scanner.nextLine();

        try {
            manager.addCourse(new Course(courseName, courseCode));
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addStudent() {
        System.out.print("Enter the student's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the student's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            manager.addStudent(new Student(name, id));
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void enrollStudent() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        try {
            manager.enrollStudent(courseCode, studentId);
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void setGrade() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        try {
            manager.setGrade(courseCode, studentId);
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listCourses() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

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
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();

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
}