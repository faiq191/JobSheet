public class DoubleLinkedLists {
    Node head;
    Node tail;

    public DoubleLinkedLists() {
        head = null;
        tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(Student data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void addLast(Student data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void add(Student data, int index) {
        if (index < 0 || index > getSize()) {
            System.out.println("Invalid index!");
            return;
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == getSize()) {
            addLast(data);
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(temp.prev, data, temp);
            temp.prev.next = newNode;
            temp.prev = newNode;
        }
    }

    void insertAfter(String key, Student data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.nim.equalsIgnoreCase(key)) {
                if (temp == tail) {
                    addLast(data);
                } else {
                    Node newNode = new Node(data);
                    newNode.next = temp.next;
                    newNode.prev = temp;
                    temp.next.prev = newNode;
                    temp.next = newNode;
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("Insertion failed. Data (" + key + ") not found!!");
    }

    void removeAfter(String key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.nim.equalsIgnoreCase(key)) {
                if (temp.next == null) {
                    System.out.println("No node exists after the key!");
                    return;
                } else if (temp.next == tail) {
                    removeLast();
                } else {
                    temp.next = temp.next.next;
                    if (temp.next != null) {
                        temp.next.prev = temp;
                    }
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("Key not found!");
    }

    Student getFirst() {
        if (isEmpty()) return null;
        return head.data;
    }

    Student getLast() {
        if (isEmpty()) return null;
        return tail.data;
    }

    Student getIndex(int index) {
        if (index < 0 || index >= getSize()) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    int getSize() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    int indexOf(String nim) {
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data.nim.equalsIgnoreCase(nim)) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1; // not found
    }

    void print() {
        if (!isEmpty()) {
            Node temp = head;
            while (temp != null) {
                temp.data.print();
                temp = temp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Double linked list is currently empty!!");
        }
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    void remove(int index) {
        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!!");
        } else if (index < 0 || index >= getSize()) {
            System.out.println("Invalid index!!");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            if (temp == tail) {
                removeLast();
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }
    }
}