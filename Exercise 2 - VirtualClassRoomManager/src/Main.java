import exceptions.*;
import java.util.logging.*;
import repository.*;
import services.*;
import utils.InputUtils;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        setupLogger();

        ClassroomRepository classRepo = new ClassroomRepository();
        StudentRepository studentRepo = new StudentRepository();
        AssignmentRepository assignmentRepo = new AssignmentRepository();

        ClassroomService classService = new ClassroomService(classRepo);
        StudentService studentService = new StudentService(studentRepo, classRepo);
        AssignmentService assignmentService = new AssignmentService(assignmentRepo, classRepo);

        logger.info("Welcome to Virtual Classroom Manager");

        boolean running = true;
        while (running) {
            System.out.print("Enter command: ");
            String input = InputUtils.nextLine();
            if (input == null || input.isEmpty()) {
                logger.warning("No command entered.");
                continue;
            }

            String[] parts = input.trim().split(" ", 2);
            String command = parts[0].toLowerCase();
            String argsLine = parts.length > 1 ? parts[1].trim() : "";

            try {
                switch (command) {
                    case "add_classroom":
                        classService.addClassroom(argsLine);
                        break;

                    case "remove_classroom":
                        classService.removeClassroom(argsLine);
                        break;

                    case "list_classrooms":
                        classService.listClassrooms();
                        break;

                    case "add_student":
                        handleAddStudent(studentService, argsLine);
                        break;

                    case "list_students":
                        studentService.listStudents(argsLine);
                        break;

                    case "schedule_assignment":
                        handleScheduleAssignment(assignmentService, argsLine);
                        break;

                    case "submit_assignment":
                        handleSubmitAssignment(assignmentService, argsLine);
                        break;

                    case "list_assignments":
                        assignmentService.listAssignments(argsLine);
                        break;

                    case "exit":
                        logger.info("Exiting Virtual Classroom Manager");
                        running = false;
                        break;

                    default:
                        logger.warning("Unknown command!");
                }
            } catch (ClassroomNotFoundException | StudentAlreadyExistsException e) {
                logger.warning(e.getMessage());
            } catch (Exception e) {
                logger.severe("Unexpected error: " + e.getMessage());
            }
        }

        // Close scanner on exit
        InputUtils.closeScanner();
    }

    private static void setupLogger() {
        try {
            FileHandler fh = new FileHandler("vcm.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setUseParentHandlers(true); // console + file
        } catch (Exception e) {
            logger.warning("Failed to initialize file logger: " + e.getMessage());
        }
    }

    private static void handleAddStudent(StudentService studentService, String argsLine) throws ClassroomNotFoundException, StudentAlreadyExistsException {
        String[] studentArgs = argsLine.split(" ");
        if (studentArgs.length != 2) {
            logger.warning("Invalid student input! Usage: add_student <student_id> <class_name>");
            return;
        }
        studentService.addStudent(studentArgs[0], studentArgs[1]);
    }

    private static void handleScheduleAssignment(AssignmentService assignmentService, String argsLine) {
        String[] assignArgs = argsLine.split(" ", 2);
        if (assignArgs.length != 2) {
            logger.warning("Invalid assignment input! Usage: schedule_assignment <class_name> <assignment_name>");
            return;
        }
        assignmentService.scheduleAssignment(assignArgs[0], assignArgs[1]);
    }

    private static void handleSubmitAssignment(AssignmentService assignmentService, String argsLine) {
        String[] submitArgs = argsLine.split(" ", 3);
        if (submitArgs.length != 3) {
            logger.warning("Invalid submission input! Usage: submit_assignment <student_id> <class_name> <assignment_name>");
            return;
        }
        assignmentService.submitAssignment(submitArgs[0], submitArgs[1], submitArgs[2]);
    }
}
