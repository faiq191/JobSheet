import java.util.Scanner;

public class StudentQueueApp {

    // === Student class ===
    static class Student {
        String id, name, major;

        Student(String id, String name, String major) {
            this.id = id;
            this.name = name;
            this.major = major;
        }

        @Override
        public String toString() {
            return id + " | " + name + " | " + major;
        }
    }

    // === Node class ===
    static class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    // === Queue class implemented using Linked List ===
    static class StudentQueue {
        Node front, rear;
        int size;
        int capacity;  // -1 means unlimited

        StudentQueue(int capacity) {
            this.capacity = capacity <= 0 ? -1 : capacity;
            clear();
        }

        boolean isEmpty() {
            return size == 0;
        }

        boolean isFull() {
            return capacity != -1 && size == capacity;
        }

        void clear() {
            front = rear = null;
            size = 0;
        }

        int size() {
            return size;
        }

        boolean enqueue(Student s) {
            if (isFull()) return false;
            Node newNode = new Node(s);
            if (isEmpty()) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            size++;
            return true;
        }

        Student dequeue() {
            if (isEmpty()) return null;
            Student s = front.data;
            front = front.next;
            if (front == null) rear = null;
            size--;
            return s;
        }

        Student peekFront() {
            return isEmpty() ? null : front.data;
        }

        Student peekRear() {
            return isEmpty() ? null : rear.data;
        }
    }

    // === Main Program ===
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Maximum queue size (0 = unlimited): ");
        int cap = sc.nextInt();
        sc.nextLine();
        StudentQueue queue = new StudentQueue(cap);

        while (true) {
            showMenu();
            int choice = readInt(sc, "Choose menu option: ");

            switch (choice) {
                case 1 -> registerStudent(queue, sc);
                case 2 -> callNextStudent(queue);
                case 3 -> showFrontRear(queue);
                case 4 -> System.out.println("Total students in queue: " + queue.size());
                case 5 -> {
                    queue.clear();
                    System.out.println("Queue cleared.");
                }
                case 0 -> {
                    System.out.println("Good-bye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
            System.out.println();
        }
    }

    static void showMenu() {
        System.out.println("""
                ------------------------------
                STUDENT SERVICE QUEUE
                1. Register / join queue
                2. Call next student
                3. Show first & last student
                4. Show total students
                5. Clear queue
                0. Exit
                ------------------------------""");
    }

    static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print(prompt);
        }
        int x = sc.nextInt();
        sc.nextLine();
        return x;
    }

    static void registerStudent(StudentQueue q, Scanner sc) {
        if (q.isFull()) {
            System.out.println("Queue is full – cannot register.");
            return;
        }
        System.out.print("  Student ID  : ");
        String id = sc.nextLine();
        System.out.print("  Name        : ");
        String name = sc.nextLine();
        System.out.print("  Major/Class : ");
        String cls = sc.nextLine();

        boolean ok = q.enqueue(new Student(id, name, cls));
        System.out.println(ok ? "Student added to queue." : "Failed to add student.");
    }

    static void callNextStudent(StudentQueue q) {
        Student s = q.dequeue();
        if (s == null) {
            System.out.println("No students in queue.");
        } else {
            System.out.println("Now serving: " + s);
        }
    }

    static void showFrontRear(StudentQueue q) {
        if (q.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Front: " + q.peekFront());
        System.out.println("Rear : " + q.peekRear());
    }
}
