# Ei-Study (KEERTHIGA K S - 224002)
Exercise 1: Design Patterns in Java

Overview

This project demonstrates the practical use of six common software design patterns in Java:

Behavioural Patterns: Observer, State

Creational Patterns: Factory Method, Prototype

Structural Patterns: Decorator, Proxy


The program is designed to be interactive, allowing users to choose any use case, provide inputs, and see dynamic outputs. It is modular, package-based, and follows best practices in logging, input validation, exception handling, and performance optimization.
Features
1. Behavioural Patterns

Observer Pattern (Weather Station)
Multiple display devices are updated automatically when temperature or humidity changes.

State Pattern (Traffic Light)
Traffic light cycles through Red → Green → Yellow states interactively.

2. Creational Patterns

Factory Method (Shape Creator)
Dynamically creates shapes (Circle, Square, Rectangle) based on user choice.

Prototype Pattern (Document Cloning)
Clone a template document and modify copies without altering the original.

3. Structural Patterns

Decorator Pattern (Coffee)
Dynamically add milk and sugar to a base coffee object and calculate the updated cost.

Proxy Pattern (Image Viewer)
Lazy loading of images — images are loaded only when displayed for the first time.

How to Run

Step 1: Compile the project

javac -d bin $(Get-ChildItem -Recurse -Filter "*.java" | ForEach-Object { $_.FullName })

Step 2: Run the program

java -cp bin DesignPatternsDemo

Commands and Sample Inputs/Outputs

PS D:\Exercise 1 - Design Patterns> java -cp bin DesignPatternsDemo

=== Design Patterns Menu ===
1. Observer Pattern (Weather Station)
2. State Pattern (Traffic Light)       
3. Factory Pattern (Shape Creator)     
4. Prototype Pattern (Document Cloning)
5. Decorator Pattern (Coffee)
6. Proxy Pattern (Image Viewer)
7. Exit

Choose a use case to run: 1

--- Observer Pattern: Weather Station ---
1. Register Display Device
2. Remove Display Device
3. Update Temperature & Humidity
4. List Registered Devices
5. Back to Main Menu

Enter choice: 1

Device name: computer1

Oct 02, 2025 12:25:07 AM Behavioural.Observer.ObserverMenu run

INFO: Device registered: computer1

--- Observer Pattern: Weather Station ---
1. Register Display Device
2. Remove Display Device
3. Update Temperature & Humidity
4. List Registered Devices
5. Back to Main Menu

Enter choice: 3

Temperature (°C): 28

Humidity (%): 33

computer1 Display -> Temperature: 28.0°C, Humidity: 33.0%

Oct 02, 2025 12:25:41 AM Behavioural.Observer.ObserverMenu run

INFO: Weather updated: Temp=28.0, Hum=33.0

--- Observer Pattern: Weather Station ---
1. Register Display Device
2. Remove Display Device
3. Update Temperature & Humidity
4. List Registered Devices
5. Back to Main Menu

Enter choice: 5

=== Design Patterns Menu ===
1. Observer Pattern (Weather Station)
2. State Pattern (Traffic Light)
3. Factory Pattern (Shape Creator)
4. Prototype Pattern (Document Cloning)
5. Decorator Pattern (Coffee)
6. Proxy Pattern (Image Viewer)
7. Exit

Choose a use case to run: 2

--- State Pattern: Traffic Light ---
1. Show Current State
2. Advance to Next State
3. Back to Main Menu

Enter choice: 1

Current Traffic Light: RED

--- State Pattern: Traffic Light ---
1. Show Current State
2. Advance to Next State
3. Back to Main Menu

Enter choice: 3

=== Design Patterns Menu ===
1. Observer Pattern (Weather Station)
2. State Pattern (Traffic Light)
3. Factory Pattern (Shape Creator)
4. Prototype Pattern (Document Cloning)
5. Decorator Pattern (Coffee)
6. Proxy Pattern (Image Viewer)
7. Exit

Choose a use case to run: 7

Exiting program...

Similar interactive menus exist for all six use cases.


Exercise 2 (Mini Project) - Virtual Classroom Manager

Overview

  Virtual Classroom Manager is a terminal-based Java application that allows users to manage virtual classrooms, students, and assignments efficiently.
  The program follows best practices in Java coding, including logging, exception handling, input validation, and modular architecture.
  It is suitable for educational institutions or online courses that want a lightweight, console-based classroom management system.

Features

1.Classroom Management :
        Add, list, and remove classrooms.
		Validates classroom existence to prevent duplicates or removal of non-existing classrooms.

2.Student Management :
        Enroll students into classrooms.
        List students in each classroom.
        Prevents duplicate student entries and invalid classroom assignment.

3.Assignment Management :
        Schedule assignments for classrooms.
        Students can submit assignments.
        List all assignments in a classroom.
        Validates submissions against classroom enrollment and scheduled assignments.

4.Gold Standard Practices :
        Logging mechanism with timestamps (java.util.logging).
        Exception handling for invalid inputs.
        Defensive programming and input validation.
        Modular code structure (Models, Repositories, Services).
        No hard-coded infinite loops; long-running program uses controlled loop.


How to Run

Step 1: Clone the repository

git clone https://github.com/yourusername/Ei-Study.git

Step 2: Compile the project

javac -d bin $(Get-ChildItem -Recurse -Filter "*.java" | ForEach-Object { $_.FullName })

Step 3: Run the program

java -cp bin Main

Commands and Sample Inputs/Outputs

PS D:\VirtualClassroomManager> java -cp bin Main

Oct 01, 2025 1:33:52 AM Main main

INFO: Welcome to Virtual Classroom Manager

1. Classroom Management

a)Add Classroom

Enter command: add_classroom cs01

Oct 01, 2025 1:34:42 AM services.ClassroomService addClassroom

INFO: Classroom 'cs01' has been created.

Enter command: add_classroom cs02

Oct 01, 2025 1:34:53 AM services.ClassroomService addClassroom

INFO: Classroom 'cs02' has been created.

b)List Classrooms

Enter command: list_classrooms

Oct 01, 2025 1:36:48 AM services.ClassroomService listClassrooms

INFO: Classrooms:

Oct 01, 2025 1:36:48 AM services.ClassroomService listClassrooms

INFO: - cs02

Oct 01, 2025 1:36:48 AM services.ClassroomService listClassrooms

INFO: - cs01

c)Remove Classroom

Enter command: remove_classroom cs01 

Oct 01, 2025 1:37:39 AM services.ClassroomService removeClassroom

INFO: Classroom 'cs01' has been removed.

2. Student Management

a)Add Student

Enter command: add_student aaa cs02

Oct 01, 2025 1:39:20 AM services.StudentService addStudent

INFO: Student 'aaa' has been enrolled in classroom 'cs02'

Enter command: add_student bbb cs02

Oct 01, 2025 1:39:32 AM services.StudentService addStudent

INFO: Student 'bbb' has been enrolled in classroom 'cs02'

b)List Students

Enter command: list_students cs02

Oct 01, 2025 1:40:38 AM services.StudentService listStudents

INFO: Students in classroom 'cs02':

Oct 01, 2025 1:40:38 AM services.StudentService listStudents

INFO: - aaa

Oct 01, 2025 1:40:38 AM services.StudentService listStudents

INFO: - bbb

3. Assignment Management

a)Schedule Assignment

Enter command: schedule_assignment cs02 ass1 

Oct 01, 2025 1:42:03 AM services.AssignmentService scheduleAssignment

INFO: Assignment 'ass1' scheduled for classroom 'cs02'

Enter command: schedule_assignment cs02 ass2

Oct 01, 2025 1:42:09 AM services.AssignmentService scheduleAssignment

INFO: Assignment 'ass2' scheduled for classroom 'cs02'

b)Submit Assignment

Enter command: submit_assignment aaa cs02 ass1                 

Oct 01, 2025 1:42:59 AM services.AssignmentService submitAssignment

INFO: Assignment 'ass1' submitted by Student 'aaa' in classroom 'cs02'

c)List Assignments

Enter command: list_assignments cs02

Oct 01, 2025 1:43:53 AM services.AssignmentService listAssignments

INFO: Assignments for classroom 'cs02':

Oct 01, 2025 1:43:53 AM services.AssignmentService listAssignments

INFO: - ass2

Oct 01, 2025 1:43:53 AM services.AssignmentService listAssignments

INFO: - ass1

4. Exit

Enter command: exit

Oct 01, 2025 1:44:30 AM Main main

INFO: Exiting Virtual Classroom Manager


Logging
        All actions are logged in vcm.log with timestamps.
        Console and file logs provide a complete audit trail.

Oct 01, 2025 1:33:52 AM Main main

INFO: Welcome to Virtual Classroom Manager

Oct 01, 2025 1:44:30 AM Main main

INFO: Exiting Virtual Classroom Manager

Technologies Used :
        Java 17+
        Collections Framework: List, Map
        Logging: java.util.logging
        Modular Architecture: Services, Repositories, Models, Exceptions
