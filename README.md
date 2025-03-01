# Student Management

## Single EnrollmentRepository vs EnrollmentRepository + Student.enrollments + Course.enrollments

It's better to have a single source of truth for enrollments in the EnrollmentRepository. This approach simplifies the data management and ensures consistency. You can remove the Set<Enrollment> from Student and Course and instead create methods in the EnrollmentRepository to fetch enrollments by studentId or courseId.

## Map for storing enrollments

It is better to store the enrollments in a Map rather than a Set in the EnrollmentRepository. Here are the reasons why:

Efficient Lookup: A Map allows for efficient lookup, insertion, and deletion of enrollments based on a composite key (e.g., EnrollmentKey consisting of studentId and courseId). This is more efficient than searching through a Set.

Unique Keys: Using a Map ensures that each enrollment is uniquely identified by its key. This prevents duplicate enrollments for the same student and course combination.

Direct Access: With a Map, you can directly access an enrollment using its key without having to iterate through the entire collection. This is particularly useful for operations like getting or removing a specific enrollment.

Flexibility: A Map provides more flexibility in terms of how you manage and access the data. You can easily retrieve all enrollments, filter by student or course, and perform other operations efficiently.

## Set when returning enrollments of a student or course

Returning enrollments in a `Set` rather than a `Map` in the methods `enrollmentRepository.getByCourseId(courseId)` and `enrollmentRepository.getByStudentId(studentId)` has several advantages:

1. **Simplicity**: A `Set` is simpler to work with when you only need a collection of unique enrollments. It directly represents a collection of items without the need for key-value pairs.

2. **Uniqueness**: A `Set` inherently ensures that all elements are unique. This is useful for enrollments, as you typically want to avoid duplicate entries.

3. **Use Case Alignment**: The primary use case for these methods is to retrieve all enrollments for a given student or course. A `Set` is a natural fit for this purpose, as it provides a collection of enrollments without the overhead of managing keys.

4. **Performance**: In many cases, operations on a `Set` can be more efficient than on a `Map`, especially when you don't need to access elements by a specific key.

5. **Readability**: Returning a `Set` makes the method's purpose clearer. It indicates that the method is providing a collection of enrollments, not a mapping of keys to enrollments.

## Filtering and collecting the Enrollment objects into a Set (EnrollmentRepository.getByStudentId)

1. **Accessing Values**:
   - `records.values()`: This retrieves a collection of all the `Enrollment` objects stored in the `records` map. The `records` map has `EnrollmentKey` as the key and `Enrollment` as the value.

2. **Creating a Stream**:
   - `.stream()`: Converts the collection of `Enrollment` objects into a stream. A stream is a sequence of elements that supports various methods which can be pipelined to produce the desired result.

3. **Filtering the Stream**:
   - `.filter(e -> e.getStudent().getId().equals(studentId))`: This applies a filter to the stream. The filter uses a lambda expression to check each `Enrollment` object (`e`) in the stream. It keeps only those `Enrollment` objects where the `studentId` of the `Student` associated with the `Enrollment` matches the `studentId` passed to the method.

4. **Collecting the Results**:
   - `.collect(Collectors.toSet())`: This collects the filtered `Enrollment` objects into a `Set`. The `Collectors.toSet()` method is a collector that accumulates the elements of the stream into a new `Set`.

### Summary

The `getByStudentId` method retrieves all `Enrollment` objects from the `records` map, filters them to include only those enrollments where the `studentId` matches the provided `studentId`, and collects the filtered enrollments into a `Set`. This `Set` is then returned by the method.

This approach ensures that you get a collection of all enrollments for a specific student, leveraging the power of Java Streams for concise and efficient data processing.

## Set for CrudRepository getAll()

 It makes more sense for the getAll method in the CrudRepository interface to return a Set<T> instead of a Map<Integer, T>. This is because the purpose of the getAll method is to retrieve all the items in the repository, and a Set is a more appropriate data structure for representing a collection of unique items.

Explanation
CrudRepository Interface:

The getAll method now returns a Set<T> instead of a Map<Integer, T>. This change reflects the intention of retrieving all items in the repository as a collection of unique items.
Repository Class:

The getAll method implementation uses Java Streams to collect the values of the records map into a Set. This ensures that the method returns a collection of unique items.
By making these changes, you align the getAll method with its intended purpose of retrieving all items in the repository, and you use a more appropriate data structure (Set) for this purpose.