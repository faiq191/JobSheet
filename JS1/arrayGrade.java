import java.util.Scanner;

public class arrayGrade {
    public static void main(String[] args) {
        data data = new data();
        mainMenu(data);
        convertToNilai(data);
        ipCalculation(data);
        viewScore(data);
    }

    public static class data {
        private static final String[] MK = {
                "Pancasila",
                "Konsep Teknologi Informasi",
                "Critical Thinking dan Problem Solving",
                "Matematika Dasar",
                "Bahasa Inggris",
                "Dasar Pemrograman",
                "Praktikum Dasar Pemrograman",
                "Keselamatan dan Kesehatan Kerja"
        };

        String[] letterGrade = new String[8];
        double[] nilai = new double[8];
        double[] score = new double[8];
        double totalNilai = 0;
        double ip = 0;

    }

    public static void mainMenu(data data) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===============================");
        System.out.println("Program Menghitung IP Semester");
        System.out.println("===============================");

        for (int i = 0; i < data.MK.length; i++) {
            System.out.print("Masukkan nilai Angka untuk MK " + data.MK[i] + ": ");
            data.score[i] = scanner.nextDouble();
        }
    }

    public static void convertToNilai(data data) {
        for (int i = 0; i < data.MK.length; i++) {
            if (data.score[i] >= 80 && data.score[i] <= 100) {
                data.letterGrade[i] = "A";
                data.nilai[i] = 4;
            } else if (data.score[i] >= 73 && data.score[i] < 80) {
                data.letterGrade[i] = "B+";
                data.nilai[i] = 3.5;
            } else if (data.score[i] >= 65 && data.score[i] < 73) {
                data.letterGrade[i] = "B";
                data.nilai[i] = 3;
            } else if (data.score[i] >= 60 && data.score[i] < 65) {
                data.letterGrade[i] = "C+";
                data.nilai[i] = 2.5;
            } else if (data.score[i] >= 50 && data.score[i] < 60) {
                data.letterGrade[i] = "C";
                data.nilai[i] = 2;
            } else if (data.score[i] >= 39 && data.score[i] < 50) {
                data.letterGrade[i] = "D";
                data.nilai[i] = 1;
            } else {
                data.letterGrade[i] = "E";
                data.nilai[i] = 0;
            }
        }
    }

    public static void ipCalculation(data data) {
        for (int i = 0; i < data.MK.length; i++) {
            data.totalNilai += data.nilai[i];
        }
        data.ip = data.totalNilai / data.MK.length;
    }

    public static void viewScore(data data) {
        System.out.println("===============================");
        System.out.println("Hasil Konversi Nilai");
        System.out.println("===============================");

        System.out.printf("%-43s %-20s %-20s %-20s\n", "MK", "Nilai Angka", "Nilai Huruf", "Bobot Nilai");
        for (int i = 0; i < data.MK.length; i++) {
            System.out.printf("%-43s %-20.2f %-20s %-20.2f\n", data.MK[i], data.score[i],
                    data.letterGrade[i], data.nilai[i]);
        }
        System.out.println("===============================");
        System.out.printf("IP: %-1.2f", data.ip);
    }
}