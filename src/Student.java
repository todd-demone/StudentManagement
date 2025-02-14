import java.util.Set;
import java.util.HashSet;

public class Student {

    private String name;
    private int id;
    private Set<Course> courses;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new HashSet<>();
    }

    public String toString() {
        return name + " (ID: " + this.id + ")";
    }

    public String addCourse(Course course) {
        boolean added = this.courses.contains(course);
        if (added) {
            return "Error: " + course + " has already been added to " + this.name + "'s course list.";
        } else {
            this.courses.add(course);
            return course + "added to " + this.name + "'s course list.";
        }
    }

//    public void displayCourses() {
//        System.out.printf("%s's Courses for this year:%n", this.name);
//        for (Course course: courses) {
//            System.out.printf("- %s%n", course);
//        }
//        System.out.println();
//    }
    public Set<Course> getCourseList() {
        return new HashSet<>(this.courses); // returns a copy of the HashSet
    }
}
