package models;

public class Student {
    private final String id;
    private final String className;

    public Student(String id, String className) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("Student ID cannot be empty");
        if (className == null || className.isEmpty()) throw new IllegalArgumentException("Class name cannot be empty");

        this.id = id;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }
}
