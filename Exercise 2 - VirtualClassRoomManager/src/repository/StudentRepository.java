package repository;

import models.Student;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.logging.Logger;

public class StudentRepository {
    private static final Logger logger = Logger.getLogger(StudentRepository.class.getName());
    private final Map<String, Student> students;

    public StudentRepository() {
        this.students = new HashMap<>();
    }

    // Add a student with validation
    public void addStudent(Student student) {
        if (student == null || student.getId() == null || student.getId().isEmpty()) {
            logger.warning("Cannot add null student or student with null/empty ID.");
            return;
        }
        students.put(student.getId(), student);
    }

    // Get a student by ID
    public Student getStudent(String id) {
        return students.get(id);
    }

    // Check if student exists
    public boolean exists(String id) {
        return students.containsKey(id);
    }

    // Remove a student by ID
    public void removeStudent(String id) {
        if (!students.containsKey(id)) {
            logger.warning("Cannot remove student. Student does not exist: " + id);
            return;
        }
        students.remove(id);
    }

    // Get all students (unmodifiable)
    public Map<String, Student> getAllStudents() {
        return Collections.unmodifiableMap(students);
    }
}
