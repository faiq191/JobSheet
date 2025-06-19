public class BinaryTreeArrayMain12 {
    public static void main(String[] args) {
        BinaryTreeArray12 bta = new BinaryTreeArray12();

        Student12 m1 = new Student12("244107020138", "Devin", "TI-1I", 3.57);
        Student12 m2 = new Student12("244107020023", "Dewi", "TI-1I", 3.85);
        Student12 m3 = new Student12("244107020225", "Wahyu", "TI-1I", 3.21);
        Student12 m4 = new Student12("244107020076", "Angelina", "TI-1I", 3.54);
        Student12 m5 = new Student12("244107020223", "Andhika", "TI-1I", 3.72);
        Student12 m6 = new Student12("244107020226", "Bima", "TI-1I", 3.37);
        Student12 m7 = new Student12("244107020181", "Eiyu", "TI-1I", 3.46);

        Student12[] data = {m1, m2, m3, m4, m5, m6, m7};
        bta.populateData(data, data.length - 1);

        System.out.println("In-order traversal:");
        bta.traverseInOrder(0);
    }
}
