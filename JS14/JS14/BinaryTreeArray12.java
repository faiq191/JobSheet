public class BinaryTreeArray12 {
    Student12[] data;
    int idxLast;

    public BinaryTreeArray12() {
        data = new Student12[10];
        idxLast = -1;
    }

    void populateData(Student12[] data, int idxLast) {
        this.data = data;
        this.idxLast = idxLast;
    }

    public void add(Student12 student) {
        if (idxLast + 1 < data.length) {
            idxLast++;
            data[idxLast] = student;
        } else {
            System.out.println("Tree array is full!");
        }
    }

    public void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast && data[idxStart] != null) {
            traverseInOrder(2 * idxStart + 1);
            data[idxStart].print();
            traverseInOrder(2 * idxStart + 2);
        }
    }

    public void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast && data[idxStart] != null) {
            data[idxStart].print();
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }
}