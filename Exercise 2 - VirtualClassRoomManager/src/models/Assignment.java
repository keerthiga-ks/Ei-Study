package models;

import java.util.HashSet;
import java.util.Set;

public class Assignment {
    private final String name;           // assignment name / details
    private final String className;      // classroom name
    private final Set<String> submittedStudents;  // students who submitted

    public Assignment(String name, String className) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Assignment name cannot be empty");
        if (className == null || className.isEmpty()) throw new IllegalArgumentException("Class name cannot be empty");

        this.name = name;
        this.className = className;
        this.submittedStudents = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public Set<String> getSubmittedStudents() {
        return submittedStudents;
    }

    // Record a student's submission
    public void submit(String studentId) {
        if (studentId == null || studentId.isEmpty()) throw new IllegalArgumentException("Student ID cannot be empty");
        submittedStudents.add(studentId);
    }

    // Check if a student has submitted
    public boolean hasSubmitted(String studentId) {
        return submittedStudents.contains(studentId);
    }
}
