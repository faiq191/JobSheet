import java.util.Scanner;

public class Selection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Program Menghitung Nilai Akhir");
        System.out.println("==============================");
        System.out.print("Masukkan Nilai Tugas: ");
        double nilaiTugas = sc.nextDouble();

        System.out.print("Masukkan Nilai Quiz: ");
        double nilaiQuiz = sc.nextDouble();

        System.out.print("Masukkan Nilai Uts: ");
        double nilaiUts = sc.nextDouble();

        System.out.print("Masukkan Nilai Uas: ");
        double nilaiUas = sc.nextDouble();
        System.out.println("==============================");
        System.out.println("==============================");

        if (nilaiTugas < 0 || nilaiTugas > 100 || nilaiQuiz < 0 || nilaiQuiz > 100 || nilaiUts < 0 || nilaiUts > 100
                || nilaiUas < 0 || nilaiUas > 100) {
            System.out.println("Nilai Tidak Valid");
            sc.close();
            return;
        }

        double nilaiAkhir = (nilaiTugas * 0.2 + nilaiQuiz * 0.2 + nilaiUts * 0.3 + nilaiUas * 0.3);

        String nilaiHuruf;
        String kualifikasi;

        if (nilaiAkhir >= 80 && nilaiAkhir <= 100) {
            nilaiHuruf = "A";
            kualifikasi = "Sangat Baik";
        } else if (nilaiAkhir >= 73 && nilaiAkhir < 80) {
            nilaiHuruf = "B+";
            kualifikasi = "Lebih dari Baik";
        } else if (nilaiAkhir >= 65 && nilaiAkhir < 73) {
            nilaiHuruf = "B";
            kualifikasi = "Baik";
        } else if (nilaiAkhir >= 60 && nilaiAkhir < 65) {
            nilaiHuruf = "C+";
            kualifikasi = "Lebih dari Cukup";
        } else if (nilaiAkhir >= 50 && nilaiAkhir < 60) {
            nilaiHuruf = "C";
            kualifikasi = "Cukup";
        } else if (nilaiAkhir >= 39 && nilaiAkhir < 50) {
            nilaiHuruf = "D";
            kualifikasi = "Kurang";
        } else {
            nilaiHuruf = "E";
            kualifikasi = "Gagal";
        }

        System.out.println("Nilai Akhir: " + nilaiAkhir);
        System.out.println("Nilai Akhir Huruf: " + nilaiHuruf);
        System.out.println("==============================");
        System.out.println("==============================");

        if (nilaiAkhir <= 50) {
            System.out.println("ANDA GAGAL");
        } else {
            System.out.println("SELAMAT ANDA LULUS");
        }

        sc.close();
    }
}

