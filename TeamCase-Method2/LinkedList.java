public class LinkedList {

    static class Node {
        Pasien data;
        Node next;

        public Node(Pasien data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class PasienLinkedList {
        Node head, tail;

        public void enqueue(Pasien pasien) {
            Node newNode = new Node(pasien);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public Pasien dequeue() {
            if (head == null) return null;
            Pasien data = head.data;
            head = head.next;
            if (head == null) tail = null;
            return data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            int count = 0;
            Node current = head;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }

        public void printQueue() {
            Node current = head;
            while (current != null) {
                current.data.tampilkanInformasi();
                current = current.next;
            }
        }
    }

    static class TransaksiNode {
        TransaksiLayanan data;
        TransaksiNode next;

        public TransaksiNode(TransaksiLayanan data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class TransaksiLinkedList {
        TransaksiNode head, tail;

        public void add(TransaksiLayanan transaksi) {
            TransaksiNode newNode = new TransaksiNode(transaksi);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void printAll() {
            TransaksiNode current = head;
            while (current != null) {
                current.data.tampilkanTransaksi();
                current = current.next;
            }
        }
    }
}
