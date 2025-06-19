public class Node {
    Student data;
    Node prev;
    Node next;

    Node() {}

    Node(Student data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    Node(Node prev, Student data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}