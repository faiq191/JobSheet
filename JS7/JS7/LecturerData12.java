import java.util.*;

public class LecturerData12 {
    Lecturer12[] lecturerData = new Lecturer12[10];
    int idx = 0;

    void add(Lecturer12 dsn) {
        if (idx < lecturerData.length) {
            lecturerData[idx++] = dsn;
        } else {
            System.out.println("Data is full!");
        }
    }

    void print() {
        for (int i = 0; i < idx; i++) {
            lecturerData[i].print();
        }
    }

    void sortingASC() { // Bubble sort by age ascending
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 0; j < idx - i - 1; j++) {
                if (lecturerData[j].age > lecturerData[j + 1].age) {
                    Lecturer12 temp = lecturerData[j];
                    lecturerData[j] = lecturerData[j + 1];
                    lecturerData[j + 1] = temp;
                }
            }
        }
    }

    void sortingDSC() { // Selection sort by age descending
        for (int i = 0; i < idx - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < idx; j++) {
                if (lecturerData[j].age > lecturerData[maxIndex].age) {
                    maxIndex = j;
                }
            }
            Lecturer12 temp = lecturerData[i];
            lecturerData[i] = lecturerData[maxIndex];
            lecturerData[maxIndex] = temp;
        }
    }

    void sequentialSearch(String name) {
        boolean found = false;
        int count = 0;
        for (int i = 0; i < idx; i++) {
            if (lecturerData[i].name.equalsIgnoreCase(name)) {
                lecturerData[i].print();
                found = true;
                count++;
            }
        }

        if (!found) {
            System.out.println("Lecturer with name \"" + name + "\" not found.");
        } else if (count > 1) {
            System.out.println("Warning: Multiple lecturers found with the name \"" + name + "\".");
        }
    }

    void binarySearch(int age) {
        sortingASC();
        int left = 0, right = idx - 1;
        boolean found = false;
        int foundIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (lecturerData[mid].age == age) {
                found = true;
                foundIndex = mid;
                break;
            } else if (lecturerData[mid].age < age) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("No lecturer found with age " + age + ".");
        } else {
            int count = 1;
            int i = foundIndex - 1;
            while (i >= 0 && lecturerData[i].age == age) {
                i--;
                count++;
            }
            i = foundIndex + 1;
            while (i < idx && lecturerData[i].age == age) {
                i++;
                count++;
            }
            for (int j = 0; j < idx; j++) {
                if (lecturerData[j].age == age) {
                    lecturerData[j].print();
                }
            }
            if (count > 1) {
                System.out.println("Warning: Multiple lecturers found with the same age " + age + ".");
            }
        }
    }
}

