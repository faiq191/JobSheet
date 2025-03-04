import java.util.Scanner;

class Lecturer {
    String id, name;
    boolean gender; // true for Male, false for Female
    int age;

    public Lecturer(String id, String name, boolean gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}

class LecturerData {
    public static void showAllLecturerData(Lecturer[] lecturerArray) {
        for (Lecturer lecturer : lecturerArray) {
            System.out.println("ID: " + lecturer.id + ", Name: " + lecturer.name + ", Gender: " + (lecturer.gender ? "Male" : "Female") + ", Age: " + lecturer.age);
        }
    }

    public static void countLecturerByGender(Lecturer[] lecturerArray) {
        int maleCount = 0, femaleCount = 0;
        for (Lecturer lecturer : lecturerArray) {
            if (lecturer.gender) maleCount++;
            else femaleCount++;
        }
        System.out.println("Male Lecturers: " + maleCount);
        System.out.println("Female Lecturers: " + femaleCount);
    }

    public static void averageLecturerAgeByGender(Lecturer[] lecturerArray) {
        int maleTotalAge = 0, femaleTotalAge = 0, maleCount = 0, femaleCount = 0;
        for (Lecturer lecturer : lecturerArray) {
            if (lecturer.gender) {
                maleTotalAge += lecturer.age;
                maleCount++;
            } else {
                femaleTotalAge += lecturer.age;
                femaleCount++;
            }
        }
        System.out.println("Average Male Lecturer Age: " + (maleCount == 0 ? "N/A" : (maleTotalAge / maleCount)));
        System.out.println("Average Female Lecturer Age: " + (femaleCount == 0 ? "N/A" : (femaleTotalAge / femaleCount)));
    }

    public static void showOldestLecturerInfo(Lecturer[] lecturerArray) {
        Lecturer oldest = lecturerArray[0];
        for (Lecturer lecturer : lecturerArray) {
            if (lecturer.age > oldest.age) oldest = lecturer;
        }
        System.out.println("Oldest Lecturer: " + oldest.name + " (" + oldest.age + " years old)");
    }

    public static void showYoungestLecturerInfo(Lecturer[] lecturerArray) {
        Lecturer youngest = lecturerArray[0];
        for (Lecturer lecturer : lecturerArray) {
            if (lecturer.age < youngest.age) youngest = lecturer;
        }
        System.out.println("Youngest Lecturer: " + youngest.name + " (" + youngest.age + " years old)");
    }
}

public class LecturerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of lecturers: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Lecturer[] lecturers = new Lecturer[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Lecturer " + (i + 1) + ":");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Gender (true for Male, false for Female): ");
            boolean gender = scanner.nextBoolean();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            lecturers[i] = new Lecturer(id, name, gender, age);
        }
        scanner.close();

        System.out.println("\nLecturer Data:");
        LecturerData.showAllLecturerData(lecturers);
        System.out.println();
        LecturerData.countLecturerByGender(lecturers);
        System.out.println();
        LecturerData.averageLecturerAgeByGender(lecturers);
        System.out.println();
        LecturerData.showOldestLecturerInfo(lecturers);
        System.out.println();
        LecturerData.showYoungestLecturerInfo(lecturers);
    }
}
