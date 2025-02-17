import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class Student {

    private final String name;
    private final Integer id;
    private Set<Enrollment> enrollments;

    public Student(String name, Integer id) {
        Objects.requireNonNull(name, "Student name cannot be null.");
        Objects.requireNonNull(id, "Student ID cannot be null.");

        name = name.trim();

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        if (name.length() > 50) {
            throw new IllegalArgumentException("Student name must be 50 characters or less.");
        }
        if (!name.matches("^[A-Za-z'\\- ]+$")) {
            throw new IllegalArgumentException("Student name can only contain letters, spaces, hyphens and apostrophes.");
        }

        if (id <= 0) {
            throw new IllegalArgumentException("Student ID must be a positive number.");
        }
        String idString = String.valueOf(id);
        if (!idString.matches("^\\d{9}$")) {
            throw new IllegalArgumentException("Student ID must be exactly 9 digits (e.g., '123456789').");
        }

        this.name = name;
        this.id = id;
        enrollments = new HashSet<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Set<Enrollment> getEnrollments() { return new HashSet<>(enrollments); }

    public void addEnrollment(Enrollment enrollment) {
        if (!enrollments.add(enrollment)) {
            throw new IllegalArgumentException("This enrollment already exists.");
        }
    }

    @Override
    public String toString() {
        return String.format("%s (ID: %d) - enrolled in %d courses.", name, id, enrollments.size());
    }
}
