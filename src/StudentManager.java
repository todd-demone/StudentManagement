import java.util.*;

public class StudentManager {
    private final Map<Integer, Student> students = new HashMap<>();
    private final Map<String, Course> courses = new HashMap<>();

    public void addStudent(Student student) {
        if (students.containsKey(student.getId())) {
            throw new IllegalArgumentException("Student with this ID already exists.");
        }

        students.put(student.getId(), student);
        System.out.println("Student added: " + student.getName());
    }

    public void addCourse(Course course) {
        if (courses.containsKey(course.getCourseCode())) {
            throw new IllegalArgumentException("Course with this Code already exists.");
        }

        courses.put(course.getCourseCode(), course);
        System.out.println("Course added: " + course.getCourseName());
    }

    public void enrollStudent(String courseCode, int studentId) {
        Course course = courses.get(courseCode);
        Student student = students.get(studentId);

        Objects.requireNonNull(course, "Course not found.");
        Objects.requireNonNull(student, "Student not found.");

        Enrollment enrollment = new Enrollment(course, student);
        course.addEnrollment(enrollment);
        student.addEnrollment(enrollment);
    }

    public void setGrade(String courseCode, int studentId) {
        Course course = courses.get(courseCode);
        Student student = students.get(studentId);

        Objects.requireNonNull(course, "Course not found.");
        Objects.requireNonNull(student, "Student not found.");

    }

//    public Set<Enrollment> getEnrollmentsStudent(int studentId) {
//        Student student = students.get(studentId);
//        return student.getEnrollments();
//    }
//
//    public Set<Enrollment> getEnrollmentsCourse(String courseCode) {
//       Course course = courses.get(courseCode);
//       return course.getEnrollments();
//    }

    public Student getStudent(int studentId) { return students.get(studentId); }
    public Course getCourse(String courseCode) { return courses.get(courseCode); }
}
