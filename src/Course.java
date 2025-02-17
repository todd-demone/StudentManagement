
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class Course {
    private String courseName;
    private String courseCode;
    private Set<Enrollment> enrollments;

    public Course(String courseName, String courseCode) {
        Objects.requireNonNull(courseName, "Course name cannot be null.");
        Objects.requireNonNull(courseCode, "Course code cannot be null.");

        courseName = courseName.trim();
        courseCode = courseCode.trim().toUpperCase();

        if (courseName.isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty.");
        }
        if (courseCode.isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be empty.");
        }

        if (courseName.length() > 100) {
            throw new IllegalArgumentException("Course name must be 100 characters or less.");
        }
        if (!courseCode.matches("^[A-Za-z]{3}\\d{3}$")) {
            throw new IllegalArgumentException("Course code must be exactly 6 characters; first 3 letters, last 3 digits (e.g., CSC101).");
        }

        this.courseName = courseName;
        this.courseCode = courseCode;

        enrollments = new HashSet<>();
    }

    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public Set<Enrollment> getEnrollments() {
        return new HashSet<>(enrollments);
    }

    public void addEnrollment(Enrollment enrollment) {
        if (!enrollments.add(enrollment)) {
            throw new IllegalArgumentException("This enrollment already exists.");
        }
    }

//    public Enrollment getEnrollment(Student student) {
//        return enrollments["student"] == "jack";
//    }



    @Override
    public String toString() {
        return String.format("%s (%s) - %d students enrolled", courseName, courseCode, enrollments.size());
    }
}
