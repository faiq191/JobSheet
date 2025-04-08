import java.util.*;

public class LecturerDemo12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LecturerData12 data = new LecturerData12();

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Data");
            System.out.println("2. Display Data");
            System.out.println("3. Sort ASC by Age (Bubble Sort)");
            System.out.println("4. Sort DSC by Age (Selection Sort)");
            System.out.println("5. Search by Name (Sequential Search)");
            System.out.println("6. Search by Age (Binary Search)");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Gender (true=Male, false=Female): ");
                    boolean gender = sc.nextBoolean();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    data.add(new Lecturer12(id, name, gender, age));
                    break;
                case 2:
                    data.print();
                    break;
                case 3:
                    data.sortingASC();
                    System.out.println("Sorted by age ascending.");
                    data.print();
                    break;
                case 4:
                    data.sortingDSC();
                    System.out.println("Sorted by age descending.");
                    data.print();
                    break;
                case 5:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    data.sequentialSearch(searchName);
                    break;
                case 6:
                    System.out.print("Enter age to search: ");
                    int searchAge = sc.nextInt();
                    data.binarySearch(searchAge);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
