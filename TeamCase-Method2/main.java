import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pilihan;

        do {
            System.out.println("\n=== SISTEM ANTRIAN KLINIK ===");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cek Sisa Antrian");
            System.out.println("5. Lihat Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1" -> TransaksiLayanan.tambahPasien(scanner);
                case "2" -> TransaksiLayanan.lihatAntrian();
                case "3" -> TransaksiLayanan.layaniPasien(scanner);
                case "4" -> TransaksiLayanan.cekSisaAntrian();
                case "5" -> TransaksiLayanan.lihatRiwayat();
                case "0" -> System.out.println("Terima kasih telah menggunakan sistem.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (!pilihan.equals("0"));
    }
}
