import java.util.ArrayList;

public class Student {

    private String name;
    private int id;
    private ArrayList<Course> courses;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.printf("%s has been added to %s's course list.%n", course.display(), this.name);
    }

    public void displayCourses() {
        System.out.printf("%s's Courses for this year:%n", this.name);
        for (Course course: courses) {
            System.out.printf("- %s%n", course.display());
        }
        System.out.println();
    }
}
