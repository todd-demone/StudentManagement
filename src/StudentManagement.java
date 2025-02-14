public class StudentManagement {
    public static void main(String[] args) {
        Course biology = new Course("Biology", "BIO123");
        Course calculus = new Course("Calculus", "MAT145");
        Course food = new Course("Food Preparation", "HEC167");

        Student jack = new Student("Jack Smith", 123456);
        Student michelle = new Student("Michelle Jones", 789123);
        Student jordan = new Student("Jordan Wilbon", 456789);

        StudentManagement manager = new StudentManagement();
        manager.enrollStudentInCourse(jack, biology);
        manager.enrollStudentInCourse(jack, calculus);
        manager.enrollStudentInCourse(michelle, calculus);
        manager.enrollStudentInCourse(jordan, food);
        manager.enrollStudentInCourse(jordan, biology);
        manager.enrollStudentInCourse(jordan, calculus);

        System.out.println("Jack's course list:");
        for (Course course : jack.getCourseList()) {
            System.out.println("- " + course);
        }

        System.out.println("Michelle's course list:");
        for (Course course : michelle.getCourseList()) {
            System.out.println("- " + course);
        }

        System.out.println("Jordan's course list:");
        for (Course course : jordan.getCourseList()) {
            System.out.println("- " + course);
        }

        System.out.println(biology.getEnrolledStudents());
        System.out.println(food.getEnrolledStudents());
        System.out.println(calculus.getEnrolledStudents());
    }

    public void enrollStudentInCourse(Student student, Course course) {
        String enrollmentMessage = course.enrollStudent(student);
        String courseMessage = student.addCourse(course);
        System.out.println(enrollmentMessage);
        System.out.println(courseMessage);
    }
}
