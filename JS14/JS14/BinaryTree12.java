public class BinaryTree12 {
    Node12 root;

    public BinaryTree12() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Add node recursively
    public void addRekursif(Student12 data) {
        root = addRekursifRecursive(root, data);
    }

    private Node12 addRekursifRecursive(Node12 current, Student12 data) {
        if (current == null) return new Node12(data);
        if (data.ipk < current.data.ipk)
            current.left = addRekursifRecursive(current.left, data);
        else if (data.ipk > current.data.ipk)
            current.right = addRekursifRecursive(current.right, data);
        return current;
    }

    public Student12 getMinIPK() {
        if (isEmpty()) return null;
        Node12 current = root;
        while (current.left != null) current = current.left;
        return current.data;
    }

    public Student12 getMaxIPK() {
        if (isEmpty()) return null;
        Node12 current = root;
        while (current.right != null) current = current.right;
        return current.data;
    }

    public void displayStudentsWithIPKAbove(double threshold) {
        displayAbove(root, threshold);
    }

    private void displayAbove(Node12 node, double threshold) {
        if (node != null) {
            displayAbove(node.left, threshold);
            if (node.data.ipk > threshold) node.data.print();
            displayAbove(node.right, threshold);
        }
    }

    public void traverseInOrder(Node12 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.data.print();
            traverseInOrder(node.right);
        }
    }
}