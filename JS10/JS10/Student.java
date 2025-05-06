public class Student {
    String nim;
    String name;
    String className;
    int grade;

    public Student(String nim, String name, String className) {
        this.nim = nim;
        this.name = name;
        this.className = className;
        this.grade = -1; // Belum dinilai
    }

    public void grading(int grade) {
        this.grade = grade;
    }
}
