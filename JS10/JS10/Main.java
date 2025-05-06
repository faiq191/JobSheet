import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExcuseLetterStack letterStack = new ExcuseLetterStack();
        int choice;

        do {
            System.out.println("\n--- Excuse Letter Management ---");
            System.out.println("1. Submit Excuse Letter");
            System.out.println("2. Process Excuse Letter");
            System.out.println("3. View Latest Excuse Letter");
            System.out.println("4. Search for Letter");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Class Name: ");
                    String className = scanner.nextLine();
                    System.out.print("Enter Type of Excuse (S for Sick, I for Other): ");
                    char type = scanner.next().charAt(0);
                    System.out.print("Enter Duration (in days): ");
                    int duration = scanner.nextInt();
                    letterStack.submitLetter(id, name, className, type, duration);
                    System.out.println("Excuse Letter submitted successfully.");
                    break;

                case 2:
                    letterStack.processLetter();
                    break;

                case 3:
                    letterStack.viewLatestLetter();
                    break;

                case 4:
                    System.out.print("Enter student's name to search for the letter: ");
                    String searchName = scanner.nextLine();
                    letterStack.searchLetterByName(searchName);
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
