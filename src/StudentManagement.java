public class StudentManagement {
    public static void main(String[] args) {
        Course biology = new Course("Biology", "BIO123");
        Course calculus = new Course("Calculus", "MAT145");
        Course food = new Course("Food Preparation", "HEC167");

        Student jack = new Student("Jack Smith", 123456);
        Student michelle = new Student("Michelle Jones", 789123);
        Student jordan = new Student("Jordan Wilbon", 456789);

        StudentManagement manager = new StudentManagement();
        manager.completeCourseAdmin(jack, biology);
        manager.completeCourseAdmin(jack, calculus);
        manager.completeCourseAdmin(michelle, calculus);
        manager.completeCourseAdmin(jordan, food);
        manager.completeCourseAdmin(jordan, biology);
        manager.completeCourseAdmin(jordan, calculus);

        jack.displayCourses();
        michelle.displayCourses();
        jordan.displayCourses();

        biology.listStudents();
        food.listStudents();
        calculus.listStudents();
    }

    public void completeCourseAdmin(Student student, Course course) {
        course.enrollStudent(student);
        student.addCourse(course);
        System.out.println();
    }
}
