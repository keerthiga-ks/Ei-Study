package models;

import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

public class Classroom {
    private final String name;
    private final Set<String> assignments;
    private final Set<String> students;

    public Classroom(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Classroom name cannot be empty");
        this.name = name;
        this.assignments = new HashSet<>();
        this.students = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    // Return unmodifiable sets to prevent external modification
    public Set<String> getAssignments() {
        return Collections.unmodifiableSet(assignments);
    }

    public Set<String> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    // Add student with validation
    public void addStudent(String studentId) {
        if (studentId == null || studentId.isEmpty()) throw new IllegalArgumentException("Student ID cannot be empty");
        students.add(studentId);
    }

    // Add assignment with validation
    public void addAssignment(String assignmentName) {
        if (assignmentName == null || assignmentName.isEmpty()) throw new IllegalArgumentException("Assignment name cannot be empty");
        assignments.add(assignmentName);
    }
}
