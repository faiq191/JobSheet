import java.util.Scanner;

public class KRSQueueMain12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KRSQueue12 queue = new KRSQueue12(10);
        int choice;

        do {
            System.out.println("\n=== KRS Approval Queue Menu ===");
            System.out.println("1. Enqueue Student");
            System.out.println("2. Process KRS (2 students)");
            System.out.println("3. View All Students");
            System.out.println("4. View First Two Students");
            System.out.println("5. View Last Student");
            System.out.println("6. Show Statistics");
            System.out.println("7. Clear Queue");
            System.out.println("0. Exit");
            System.out.print("Choose menu: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("NIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Study Program: ");
                    String program = sc.nextLine();
                    System.out.print("Class: ");
                    String className = sc.nextLine();
                    queue.enqueue(new StudentKRS12(nim, name, program, className));
                    break;
                case 2:
                    queue.dequeueTwo();
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    queue.displayFirstTwo();
                    break;
                case 5:
                    queue.displayLast();
                    break;
                case 6:
                    queue.reportStats();
                    break;
                case 7:
                    queue.clearQueue();
                    break;
                case 0:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 0);
    }
}