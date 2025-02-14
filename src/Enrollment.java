public class Enrollment {

    private Course course;
    private Student student;
    private int grade;

    public Enrollment( Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    public void addGrade(int grade) {
        this.grade = grade;
    }

    public Course getCourse() {
        return this.course;
    }

    public Student getStudent() {
        return this.student;
    }

    public int getGrade() {
        return this.grade;
    }

    public String toString() {
        return "Course: " + this.course + "; Student: " + this.student;
    }

}
