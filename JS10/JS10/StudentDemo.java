import java.util.Scanner;

public class StudentDemo {
    public static void main(String[] args) {
        StudentAssignmentStack stack = new StudentAssignmentStack(5);
        Scanner scan = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Submit Assignment");
            System.out.println("2. Grade Assignment");
            System.out.println("3. View Top Assignment");
            System.out.println("4. View All Assignments");
            System.out.println("5. Exit");
            System.out.print("Choose a menu: ");
            choice = scan.nextInt();
            scan.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scan.nextLine();
                    System.out.print("NIM: ");
                    String nim = scan.nextLine();
                    System.out.print("Class Name: ");
                    String className = scan.nextLine();
                    Student std = new Student(nim, name, className);
                    stack.push(std);
                    System.out.println(name + "'s assignment has been successfully submitted!!");
                    break;
                case 2:
                    Student graded = stack.pop();
                    if (graded != null) {
                        System.out.println("Grading assignment from " + graded.name);
                        System.out.print("Input grade (0-100): ");
                        int grade = scan.nextInt();
                        graded.grading(grade);
                        System.out.printf("Assignment grade of %s is %d\n", graded.name, grade);
                        String binary = stack.convertToBinary(grade);
                        System.out.printf("Assignment grade in binary is %s\n", binary);
                    }
                    break;
                case 3:
                    Student topStudent = stack.peek();
                    if (topStudent != null) {
                        System.out.println("The last assignment comes from " + topStudent.name);
                    }
                    break;
                case 4:
                    System.out.println("Assignment list:");
                    System.out.println("NIM\tName\tClass Name");
                    stack.print();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);

        scan.close();
    }
}
