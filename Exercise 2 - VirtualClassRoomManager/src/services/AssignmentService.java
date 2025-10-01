package services;

import models.Assignment;
import models.Classroom;
import repository.AssignmentRepository;
import repository.ClassroomRepository;
import java.util.logging.Logger;

public class AssignmentService {
    private static final Logger logger = Logger.getLogger(AssignmentService.class.getName());
    private final AssignmentRepository assignmentRepo;
    private final ClassroomRepository classRepo;

    public AssignmentService(AssignmentRepository assignmentRepo, ClassroomRepository classRepo) {
        if (assignmentRepo == null || classRepo == null)
            throw new IllegalArgumentException("Repositories cannot be null");
        this.assignmentRepo = assignmentRepo;
        this.classRepo = classRepo;
    }

    // Schedule a new assignment for a classroom
    public void scheduleAssignment(String className, String assignmentName) {
        if (className == null || className.isEmpty()) {
            logger.warning("Classroom name cannot be empty.");
            return;
        }
        if (assignmentName == null || assignmentName.isEmpty()) {
            logger.warning("Assignment name cannot be empty.");
            return;
        }
        if (!classRepo.exists(className)) {
            logger.warning("Classroom does not exist: " + className);
            return;
        }

        Assignment assignment = new Assignment(assignmentName, className);
        assignmentRepo.addAssignment(assignment);
        classRepo.getClassroom(className).addAssignment(assignmentName);

        logger.info("Assignment '" + assignmentName + "' scheduled for classroom '" + className + "'");
    }

    // Student submits an assignment
    public void submitAssignment(String studentId, String className, String assignmentName) {
        if (studentId == null || studentId.isEmpty()) {
            logger.warning("Student ID cannot be empty.");
            return;
        }
        if (className == null || className.isEmpty() || assignmentName == null || assignmentName.isEmpty()) {
            logger.warning("Classroom and Assignment names cannot be empty.");
            return;
        }
        if (!classRepo.exists(className)) {
            logger.warning("Classroom does not exist: " + className);
            return;
        }

        Classroom classroom = classRepo.getClassroom(className);
        if (!classroom.getStudents().contains(studentId)) {
            logger.warning("Student '" + studentId + "' is not enrolled in classroom '" + className + "'");
            return;
        }
        if (!classroom.getAssignments().contains(assignmentName)) {
            logger.warning("Assignment '" + assignmentName + "' is not scheduled for classroom '" + className + "'");
            return;
        }

        Assignment assignment = assignmentRepo.getAssignment(assignmentName, className);
        if (assignment == null) {
            logger.warning("Assignment data not found in repository.");
            return;
        }

        if (assignment.hasSubmitted(studentId)) {
            logger.warning("Student '" + studentId + "' has already submitted assignment '" + assignmentName + "'");
            return;
        }

        assignment.submit(studentId);
        logger.info("Assignment '" + assignmentName + "' submitted by Student '" + studentId + "' in classroom '" + className + "'");
    }

    // List all assignments for a classroom
    public void listAssignments(String className) {
        if (className == null || className.isEmpty()) {
            logger.warning("Classroom name cannot be empty.");
            return;
        }
        if (!classRepo.exists(className)) {
            logger.warning("Classroom does not exist: " + className);
            return;
        }

        Classroom classroom = classRepo.getClassroom(className);
        var assignments = classroom.getAssignments();

        if (assignments.isEmpty()) {
            logger.info("No assignments scheduled for classroom '" + className + "'");
            return;
        }

        logger.info("Assignments for classroom '" + className + "':");
        for (String a : assignments) {
            logger.info("- " + a);
        }
    }
}
