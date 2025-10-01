package repository;

import models.Classroom;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.logging.Logger;

public class ClassroomRepository {
    private static final Logger logger = Logger.getLogger(ClassroomRepository.class.getName());
    private final Map<String, Classroom> classrooms;

    public ClassroomRepository() {
        this.classrooms = new HashMap<>();
    }

    // Check if classroom exists
    public boolean exists(String className) {
        return classrooms.containsKey(className);
    }

    // Add a classroom
    public void addClassroom(Classroom classroom) {
        if (classroom == null || classroom.getName() == null) {
            logger.warning("Cannot add null classroom or classroom with null name.");
            return;
        }
        classrooms.put(classroom.getName(), classroom);
    }

    // Get a classroom by name
    public Classroom getClassroom(String className) {
        return classrooms.get(className);
    }

    // Remove classroom
    public void removeClassroom(String className) {
        if (!classrooms.containsKey(className)) {
            logger.warning("Cannot remove classroom. Classroom does not exist: " + className);
            return;
        }
        classrooms.remove(className);
    }

    // Get all classrooms (unmodifiable)
    public Map<String, Classroom> getAllClassrooms() {
        return Collections.unmodifiableMap(classrooms);
    }
}
