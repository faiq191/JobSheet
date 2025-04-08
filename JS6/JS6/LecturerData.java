public class LecturerData {
    Lecturer[] lecturerData = new Lecturer[10];
    int idx = 0;

    void add(Lecturer dsn) {
        if (idx < lecturerData.length) {
            lecturerData[idx++] = dsn;
        } else {
            System.out.println("Lecturer data is full.");
        }
    }

    void print() {
        for (int i = 0; i < idx; i++) {
            lecturerData[i].print();
        }
    }

    void sortingASC() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 0; j < idx - i - 1; j++) {
                if (lecturerData[j].age > lecturerData[j + 1].age) {
                    Lecturer temp = lecturerData[j];
                    lecturerData[j] = lecturerData[j + 1];
                    lecturerData[j + 1] = temp;
                }
            }
        }
    }

    void sortingDSC() {
        for (int i = 1; i < idx; i++) {
            Lecturer temp = lecturerData[i];
            int j = i;
            while (j > 0 && lecturerData[j - 1].age < temp.age) {
                lecturerData[j] = lecturerData[j - 1];
                j--;
            }
            lecturerData[j] = temp;
        }
    }
}
