import java.util.Set;
import java.util.HashSet;

public class Student {

    private String name;
    private int id;
    private Set<Enrollment> enrollments;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.enrollments = new HashSet<>();
    }

    public void addEnrollment(Enrollment enrollment) {
//        boolean added = this.enrollments.contains(enrollment);
//        if (added) {
//            return "Error: " + enrollment + " has already been added to " + this.name + "'s course enrollments list.";
//        } else {
            this.enrollments.add(enrollment);
//            return enrollment + "added to " + this.name + "'s course enrollments list.";
//        }
    }

    public Set<Enrollment> getEnrollments() {
        return new HashSet<>(this.enrollments); // returns a copy of the HashSet
    }

    public String toString() {
        return this.name + " (ID: " + this.id + ")";
    }
}
