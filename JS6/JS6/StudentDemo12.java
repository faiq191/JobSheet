public class StudentDemo12 {
    public static void main(String[] args) {
        TopStudents12 topStudents = new TopStudents12();

        topStudents.add(new Student12("2201", "Alice", "A", 3.9));
        topStudents.add(new Student12("2202", "Bob", "B", 3.7));
        topStudents.add(new Student12("2203", "Charlie", "C", 3.8));
        topStudents.add(new Student12("2204", "David", "D", 3.6));
        topStudents.add(new Student12("2205", "Eve", "E", 4.0));

        System.out.println("Original student list:");
        topStudents.print();

        topStudents.insertionSort();
        System.out.println("\nSorted student list (by GPA, ascending) using Insertion Sort:");
        topStudents.print();
    }
}
