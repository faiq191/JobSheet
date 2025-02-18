import java.util.Scanner;

public class Assignment2 {

    public static int displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a calculation type:");
        System.out.println("1. Volume");
        System.out.println("2. Surface Area");
        System.out.println("3. Perimeter (Total Edge Length)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
        return scanner.nextInt();
    }

    public static double calculateVolume(double side) {
        return Math.pow(side, 3);
    }

    public static double calculateSurfaceArea(double side) {
        return 6 * Math.pow(side, 2);
    }

    public static double calculatePerimeter(double side) {
        return 12 * side;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the side length of the cube: ");
        double side = scanner.nextDouble();

        int choice;
        do {
            choice = displayMenu();

            switch (choice) {
                case 1:
                    System.out.println("Volume: " + calculateVolume(side));
                    break;
                case 2:
                    System.out.println("Surface Area: " + calculateSurfaceArea(side));
                    break;
                case 3:
                    System.out.println("Perimeter (Total Edge Length): " + calculatePerimeter(side));
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
