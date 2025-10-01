package repository;

import models.Assignment;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;

public class AssignmentRepository {
    private static final Logger logger = Logger.getLogger(AssignmentRepository.class.getName());

    // Key: className + ":" + assignmentName for uniqueness
    private final Map<String, Assignment> assignments;

    public AssignmentRepository() {
        this.assignments = new HashMap<>();
    }

    private String key(String assignmentName, String className) {
        return className + ":" + assignmentName;
    }

    // Add assignment with defensive check
    public void addAssignment(Assignment assignment) {
        if (assignment == null) {
            logger.warning("Cannot add null assignment.");
            return;
        }
        if (assignment.getName() == null || assignment.getClassName() == null) {
            logger.warning("Assignment name or className cannot be null.");
            return;
        }
        assignments.put(key(assignment.getName(), assignment.getClassName()), assignment);
    }

    // Get assignment by name and class
    public Assignment getAssignment(String assignmentName, String className) {
        return assignments.get(key(assignmentName, className));
    }

    // Remove assignment
    public void removeAssignment(String assignmentName, String className) {
        assignments.remove(key(assignmentName, className));
    }

    // List all assignments for a classroom
    public List<Assignment> getAssignmentsByClass(String className) {
        if (className == null || className.isEmpty()) return Collections.emptyList();
        List<Assignment> result = new ArrayList<>();
        for (Assignment a : assignments.values()) {
            if (className.equals(a.getClassName())) {
                result.add(a);
            }
        }
        return result;
    }

    // Return unmodifiable map to prevent external changes
    public Map<String, Assignment> getAllAssignments() {
        return Collections.unmodifiableMap(assignments);
    }
}
