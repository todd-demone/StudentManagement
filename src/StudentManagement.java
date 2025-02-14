public class StudentManagement {
    public static void main(String[] args) {
        Course biology = new Course("Biology", "BIO123");
        Course calculus = new Course("Calculus", "MAT145");
        Course food = new Course("Food Preparation", "HEC167");

        Student jack = new Student("Jack Smith", 123456);
        Student michelle = new Student("Michelle Jones", 789123);
        Student jordan = new Student("Jordan Wilbon", 456789);

        StudentManagement manager = new StudentManagement();
        manager.enrollStudentInCourse(biology, jack);
        manager.enrollStudentInCourse(calculus, jack);
        manager.enrollStudentInCourse(calculus, michelle);
        manager.enrollStudentInCourse(food, jordan);
        manager.enrollStudentInCourse(biology, jordan);
        manager.enrollStudentInCourse(calculus, jordan);

        System.out.println("Jack's course list:");
        for (Enrollment enrollment : jack.getEnrollments()) {
            System.out.println("- " + enrollment.getCourse());
        }

        System.out.println("Michelle's course list:");
        for (Enrollment enrollment : michelle.getEnrollments()) {
            System.out.println("- " + enrollment.getCourse());
        }

        System.out.println("Jordan's course list:");
        for (Enrollment enrollment : jordan.getEnrollments()) {
            System.out.println("- " + enrollment.getCourse());
        }

        System.out.println("Biology: Enrolled students:");
        for (Enrollment enrollment : biology.getEnrollments()) {
            System.out.println("- " + enrollment.getStudent());
        }

        System.out.println("Calculus: Enrolled students:");
        for (Enrollment enrollment : calculus.getEnrollments()) {
            System.out.println("- " + enrollment.getStudent());
        }

        System.out.println("Food Prep: Enrolled students:");
        for (Enrollment enrollment : food.getEnrollments()) {
            System.out.println("- " + enrollment.getStudent());
        }

    }

    public void enrollStudentInCourse(Course course, Student student) {
        Enrollment enrollment = new Enrollment(course, student);
        course.addEnrollment(enrollment);
        student.addEnrollment(enrollment);
    }
}
