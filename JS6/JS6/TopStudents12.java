public class TopStudents12 {
    Student12[] listStudents = new Student12[5];
    int idx = 0;

    public void add(Student12 std) {
        if (idx < listStudents.length) {
            listStudents[idx] = std;
            idx++;
        } else {
            System.out.println("Data is full!");
        }
    }

    public void print() {
        for (int i = 0; i < idx; i++) {
            listStudents[i].print();
        }
    }

    public void insertionSort() {
        for (int i = 1; i < idx; i++) {
            Student12 temp = listStudents[i];
            int j = i;

            while (j > 0 && listStudents[j - 1].gpa > temp.gpa) {
                listStudents[j] = listStudents[j - 1];
                j--;
            }

            listStudents[j] = temp;
        }
    }
}
