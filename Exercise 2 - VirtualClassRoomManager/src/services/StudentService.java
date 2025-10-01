package services;

import exceptions.ClassroomNotFoundException;
import exceptions.StudentAlreadyExistsException;
import java.util.logging.Logger;
import models.Student;
import repository.ClassroomRepository;
import repository.StudentRepository;

public class StudentService {
    private static final Logger logger = Logger.getLogger(StudentService.class.getName());
    private final StudentRepository studentRepo;
    private final ClassroomRepository classRepo;

    public StudentService(StudentRepository studentRepo, ClassroomRepository classRepo) {
        if (studentRepo == null || classRepo == null)
            throw new IllegalArgumentException("Repositories cannot be null");
        this.studentRepo = studentRepo;
        this.classRepo = classRepo;
    }

    // Add student (id + classroom)
    public void addStudent(String id, String className) throws ClassroomNotFoundException, StudentAlreadyExistsException {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty.");
        }
        if (className == null || className.isEmpty()) {
            throw new IllegalArgumentException("Classroom name cannot be empty.");
        }
        if (!classRepo.exists(className))
            throw new ClassroomNotFoundException("Classroom does not exist: " + className);
        if (studentRepo.exists(id))
            throw new StudentAlreadyExistsException("Student already exists: " + id);

        Student student = new Student(id, className);
        studentRepo.addStudent(student);
        classRepo.getClassroom(className).addStudent(id);

        logger.info("Student '" + id + "' has been enrolled in classroom '" + className + "'");
    }

    // List students in a classroom
    public void listStudents(String className) {
        if (className == null || className.isEmpty()) {
            logger.warning("Classroom name cannot be empty.");
            return;
        }
        if (!classRepo.exists(className)) {
            logger.warning("Classroom does not exist: '" + className + "'");
            return;
        }

        var students = classRepo.getClassroom(className).getStudents();
        if (students.isEmpty()) {
            logger.info("No students enrolled in classroom '" + className + "'");
            return;
        }

        logger.info("Students in classroom '" + className + "':");
        for (String studentId : students) {
            logger.info("- " + studentId);
        }
    }
}
