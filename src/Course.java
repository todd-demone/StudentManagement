import java.util.ArrayList;

public class Course {
    private String courseName;
    private String courseCode;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        System.out.printf("%s has enrolled in %s(%s).%n", student.getName(), this.courseName, this.courseCode);
    }

    public String display() {
        return this.courseName + " (" + this.courseCode + ")";
    }

    public void listStudents() {
        System.out.printf("%s (%s) Student List:%n", this.courseName, this.courseCode);
        for (Student student: enrolledStudents) {
            System.out.printf("- %s%n", student.getName());
        }
        System.out.println();
    }


}
