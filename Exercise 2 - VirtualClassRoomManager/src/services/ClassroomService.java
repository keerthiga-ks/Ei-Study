package services;

import repository.ClassroomRepository;
import models.Classroom;
import java.util.logging.Logger;

public class ClassroomService {
    private static final Logger logger = Logger.getLogger(ClassroomService.class.getName());
    private final ClassroomRepository classRepo;

    public ClassroomService(ClassroomRepository classRepo) {
        if (classRepo == null) throw new IllegalArgumentException("ClassroomRepository cannot be null");
        this.classRepo = classRepo;
    }

    // Add a new classroom
    public void addClassroom(String className) {
        if (className == null || className.isEmpty()) {
            logger.warning("Classroom name cannot be empty.");
            return;
        }
        if (classRepo.exists(className)) {
            logger.warning("Classroom already exists: '" + className + "'");
            return;
        }
        Classroom c = new Classroom(className);
        classRepo.addClassroom(c);
        logger.info("Classroom '" + className + "' has been created.");
    }

    // List all classrooms
    public void listClassrooms() {
        var classrooms = classRepo.getAllClassrooms();
        if (classrooms.isEmpty()) {
            logger.info("No classrooms available.");
            return;
        }
        logger.info("Classrooms:");
        for (String name : classrooms.keySet()) {
            logger.info("- " + name);
        }
    }

    // Remove a classroom
    public void removeClassroom(String className) {
        if (className == null || className.isEmpty()) {
            logger.warning("Classroom name cannot be empty.");
            return;
        }
        if (!classRepo.exists(className)) {
            logger.warning("Classroom does not exist: '" + className + "'");
            return;
        }
        classRepo.removeClassroom(className);
        logger.info("Classroom '" + className + "' has been removed.");
    }
}
