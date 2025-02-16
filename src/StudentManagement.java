public class StudentManagement {
    public static void main(String[] args) {
        Course biology = new Course("Biology", "bio123");
        Course calculus = new Course("Calculus", "MAT145");
        Course food = new Course("Food Preparation", "HEC167");

        Student jack = new Student("Jack Smith", 123456789);
        Student michelle = new Student("Michelle Jones", 789123456);
        Student jordan = new Student("Jordan Miller", 456789123);

        StudentManagement manager = new StudentManagement();
        manager.enrollStudentInCourse(biology, jack);
        manager.enrollStudentInCourse(calculus, jack);
        manager.enrollStudentInCourse(calculus, michelle);
        manager.enrollStudentInCourse(food, jordan);
        manager.enrollStudentInCourse(biology, jordan);
        manager.enrollStudentInCourse(calculus, jordan);

//        biology.getEnrollment(jack).getGrade();
        manager.printEnrolledStudents(biology);
        manager.printEnrolledStudents(calculus);
        manager.printEnrolledStudents(food);

        manager.printEnrollments(jack);
        manager.printEnrollments(jack);
        manager.printEnrollments(jack);
    }

    private void enrollStudentInCourse(Course course, Student student) {
        Enrollment enrollment = new Enrollment(course, student);
        course.addEnrollment(enrollment);
        student.addEnrollment(enrollment);
    }

    private void printEnrolledStudents(Course course) {
        System.out.println(course + "Enrolled students:");
        for (Enrollment enrollment : course.getEnrollments()) {
            System.out.println("- " + enrollment.getStudent());
        }
    }

    private void printEnrollments(Student student) {
        System.out.println(student + "Course List:");
        for (Enrollment enrollment : student.getEnrollments()) {
            System.out.println("- " + enrollment.getCourse());
        }
    }
}
