public class KRSQueue12 {
    StudentKRS12[] data;
    int front, rear, size, max;
    int approvedCount = 0;

    public KRSQueue12(int n) {
        max = n;
        data = new StudentKRS12[max];
        front = 0;
        rear = -1;
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == max;
    }

    void enqueue(StudentKRS12 student) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = student;
        size++;
        System.out.printf("%s has joined the KRS approval queue.\n", student.name);
    }

    void dequeueTwo() {
        if (size < 2) {
            System.out.println("Not enough students to process (need at least 2).");
            return;
        }
        System.out.println("Processing KRS approval for:");
        for (int i = 0; i < 2; i++) {
            StudentKRS12 student = data[front];
            student.print();
            front = (front + 1) % max;
            size--;
            approvedCount++;
        }
    }

    void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("All students in queue:");
        int i = front;
        while (i != rear) {
            data[i].print();
            i = (i + 1) % max;
        }
        data[i].print();
    }

    void displayFirstTwo() {
        if (size < 1) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("First student:");
            data[front].print();
            if (size >= 2) {
                System.out.println("Second student:");
                data[(front + 1) % max].print();
            }
        }
    }

    void displayLast() {
        if (!isEmpty()) {
            System.out.println("Last student in line:");
            data[rear].print();
        } else {
            System.out.println("Queue is empty.");
        }
    }

    void reportStats() {
        System.out.println("Total students joined: " + (approvedCount + size));
        System.out.println("Students approved: " + approvedCount);
        System.out.println("Students pending: " + size);
    }

    void clearQueue() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Queue cleared.");
    }
}