// Set is an "interface"
// Set comes from the Java Collections Framework
// An interface defines a contract for anyone who wants to interact with an implementing class.
// But it doesn't tell the implementing class how to perform its task.
// Set is a "generic type" - it doesn't set out how to perform a task.
// It just tells you how to add an item, or retrieve an item.
// It doesn't tell the implementation how to prevent duplicates or store items.
import java.util.Set;
// HashSet implements the Set interface using hash tables
import java.util.HashSet;

public class Course {
    private String courseName;
    private String courseCode;
    // Why use an interface (Set) and not just go straight to the implementation (HashSet)?
    // (1) Using the interface provides more flexibility.
    // We can use any implementation of the Set interface, not just HashSet.
    // E.g., we may want to create some Course objects that use a TreeSet or LinkedHashSet instead of a HashSet.
    // "Program to the interface"
    // Polymorphism: using different classes in the same way
    // Where those classes have common interfaces or parent classes.
    // Lets you switch between different implementations either now, or in the future, without much of a code overhaul.
    // A supertype variable can refer to a subtype object
    // polymorphism - treating different classes as the same class because they share the same interface or parent class (superclass?)
    // E.g. you can call the method of a class implementing an interface, and the exact method that gets called depends
    // on the actual type of object you're dealing with.
    // Method polymorphism - where a subclass overrides a method of the parent class by defining its own version of the method.
    // Different types like HashSet, TreeSet and LinkedHashSet are interchangeable when you use the Set interface.
    // Using different objects (HashSet object, TreeSet object) in the same way
    // If set1 and set2 are declared as Set types, and we initialize set1 and set2 as HashSet and TreeSet, respectively,
    // then we can deal with those objects as if they are the same type (e.g., set1.add("foo"), set2.add("bar"))
    // variables are declared using the Set type, and values (HashSet and TreeSet) are assigned to those variables
    // DECLARE with interface, IMPLEMENT with concrete implementation
    // When would this be beneficial? Maybe it's advantageous for one variable to use Trees to organize the data,
    // i.e., to keep the data sorted. While another variable would be better off using hash tables (faster lookup?).
    // (2) It also makes the code more maintainable, since if you want to change the code in the future, all you have
    // to do is change the IMPLEMENTATION and everything will still work.
    private Set<Enrollment> enrollments;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.enrollments = new HashSet<>();
    }

    public String addEnrollment(Enrollment enrollment) {
        // Note: is there any advantage of this check if enrollments is a Set type (no duplicates)?
        boolean added = this.enrollments.contains(enrollment);
        if (added) {
            return enrollment + " is already enrolled in " + this.courseName + " (" + this.courseCode + ").";
        } else {
            this.enrollments.add(enrollment);
            return enrollment + " has been add to " + this.courseName + " (" + this.courseCode + ").";
        }
    }

    // Getter - getEnrollments()
    // Encapsulation
    // Why encapsulation? why not just allow access and modification directly from other parts of code?
    // (1) control & validation - you can put constraints in setters - aka validators - before data is modified/added.
    // e.g., make sure grade is between 0 and 100 before adding a grade to a student's record
    // (2) flexibility - freedom to change how data is stored or manipulated in the future
    // e.g., a grade could be an int now, but if you want to change it to double later, it's better to use getters
    // and setters - that way you don't have to change all the calls from 3rd party objects.
    // just modify the getter/setter method; call code remains unchanged
    // (3) security - control how data is accessed
    // e.g., an object that holds passwords wants to control access - wants to make sure passwords are encrypted
    // (4) data corruption - a 3rd party object could accidentally modify the data; encapsulation prevents direct access
    // to data so inadvertent modifications are stopped.
    public HashSet<Enrollment> getEnrollments() {
        // We don't pass the original enrolledStudents HashSet because the recipient could then modify the original.
        // It's better to pass a copy to avoid
        return new HashSet<>(this.enrollments);
    }

    public String toString() {
        return this.courseName + " (" + this.courseCode + ")";
    }
}
