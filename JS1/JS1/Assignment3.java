import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of courses: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] courseNames = new String[n];
        int[] creditHours = new int[n];
        int[] semesters = new int[n];
        String[] lectureDays = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Course " + (i + 1) + ":");
            System.out.print("Course Name: ");
            courseNames[i] = scanner.nextLine();
            System.out.print("Credit Hours (SKS): ");
            creditHours[i] = scanner.nextInt();
            System.out.print("Semester: ");
            semesters[i] = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Lecture Day (e.g., Monday, Tuesday): ");
            lectureDays[i] = scanner.nextLine();
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display all courses");
            System.out.println("2. Display courses on a specific day");
            System.out.println("3. Display courses for a specific semester");
            System.out.println("4. Search for a course by name");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllCourses(courseNames, creditHours, semesters, lectureDays);
                    break;
                case 2:
                    System.out.print("Enter the day to filter courses (e.g., Monday): ");
                    String day = scanner.nextLine();
                    displayCoursesByDay(courseNames, creditHours, semesters, lectureDays, day);
                    break;
                case 3:
                    System.out.print("Enter the semester to filter courses: ");
                    int semester = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    displayCoursesBySemester(courseNames, creditHours, semesters, lectureDays, semester);
                    break;
                case 4:
                    System.out.print("Enter the course name to search: ");
                    String searchName = scanner.nextLine();
                    searchCourseByName(courseNames, creditHours, semesters, lectureDays, searchName);
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void displayAllCourses(String[] courseNames, int[] creditHours, int[] semesters,
            String[] lectureDays) {
        System.out.println("\nAll Courses:");
        System.out.printf("%-43s %-20s %-20s %-20s\n", "Course Name", "Credit Hours", "Semester", "Lecture Day");
        for (int i = 0; i < courseNames.length; i++) {
            System.out.printf("%-43s %-20d %-20d %-20s\n", courseNames[i], creditHours[i], semesters[i],
                    lectureDays[i]);
        }
    }

    public static void displayCoursesByDay(String[] courseNames, int[] creditHours, int[] semesters,
            String[] lectureDays, String day) {
        System.out.println("\nCourses on " + day + ":");
        System.out.printf("%-43s %-20s %-20s %-20s\n", "Course Name", "Credit Hours", "Semester", "Lecture Day");
        boolean found = false;
        for (int i = 0; i < courseNames.length; i++) {
            if (lectureDays[i].equalsIgnoreCase(day)) {
                System.out.printf("%-43s %-20d %-20d %-20s\n", courseNames[i], creditHours[i], semesters[i],
                        lectureDays[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No courses found on " + day + ".");
        }
    }

    public static void displayCoursesBySemester(String[] courseNames, int[] creditHours, int[] semesters,
            String[] lectureDays, int semester) {
        System.out.println("\nCourses in Semester " + semester + ":");
        System.out.printf("%-43s %-20s %-20s %-20s\n", "Course Name", "Credit Hours", "Semester", "Lecture Day");
        boolean found = false;
        for (int i = 0; i < courseNames.length; i++) {
            if (semesters[i] == semester) {
                System.out.printf("%-43s %-20d %-20d %-20s\n", courseNames[i], creditHours[i], semesters[i],
                        lectureDays[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No courses found for Semester " + semester + ".");
        }
    }

    public static void searchCourseByName(String[] courseNames, int[] creditHours, int[] semesters,
            String[] lectureDays, String searchName) {
        System.out.printf("%-43s %-20s %-20s %-20s\n", "Course Name", "Credit Hours", "Semester", "Lecture Day");
        boolean found = false;
        for (int i = 0; i < courseNames.length; i++) {
            if (courseNames[i].equalsIgnoreCase(searchName)) {
                System.out.printf("Course found: %-43s %-20d %-20d %-20s\n", courseNames[i], creditHours[i],
                        semesters[i], lectureDays[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Course " + searchName + " not found.");
        }
    }
}