import java.util.Scanner;

public class TransaksiLayanan {
    private static LinkedList.PasienLinkedList antrianPasien = new LinkedList.PasienLinkedList();
    private static LinkedList.TransaksiLinkedList riwayatTransaksi = new LinkedList.TransaksiLinkedList();

    Pasien pasien;
    Dokter dokter;
    int durasiLayanan;
    int biaya;

    public TransaksiLayanan(Pasien pasien, Dokter dokter, int durasiLayanan) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.durasiLayanan = durasiLayanan;
        this.biaya = hitungBiaya();
    }

    public int hitungBiaya() {
        return durasiLayanan * 50000;
    }

    public void tampilkanTransaksi() {
        System.out.println(
            "-- Riwayat Transaksi -- \n Daftar Transaksi: \n" +
            pasien.nama + "(" + durasiLayanan + " Jam): Rp" + biaya
        );
    }

    public static void tambahPasien(Scanner scanner) {
        System.out.print("Nama Pasien: ");
        String nama = scanner.nextLine();
        System.out.print("NIK: ");
        String nik = scanner.nextLine();
        System.out.print("Keluhan: ");
        String keluhan = scanner.nextLine();

        Pasien pasien = new Pasien(nama, nik, keluhan);
        antrianPasien.enqueue(pasien);
        System.out.println(">> Pasien berhasil ditambahkan ke antrian.");
    }

    public static void lihatAntrian() {
        if (antrianPasien.isEmpty()) {
            System.out.println(">> Antrian kosong.");
        } else {
            antrianPasien.printQueue();
        }
    }

    public static void layaniPasien(Scanner scanner) {
        if (antrianPasien.isEmpty()) {
            System.out.println(">> Tidak ada pasien dalam antrian.");
            return;
        }

        System.out.println("Pasien " + antrianPasien.head.data.nama + " dipanggil.");
        Pasien pasien = antrianPasien.dequeue();
        System.out.print("Masukkan ID Dokter: ");
        String idDokter = scanner.nextLine();
        System.out.print("Masukkan Nama Dokter: ");
        String namaDokter = scanner.nextLine();
        System.out.print("Masukkan Durasi Layanan (jam): ");
        int durasi = scanner.nextInt();
        scanner.nextLine();

        Dokter dokter = new Dokter(idDokter, namaDokter);
        TransaksiLayanan transaksi = new TransaksiLayanan(pasien, dokter, durasi);
        riwayatTransaksi.add(transaksi);

        System.out.println(">> Pasien berhasil dilayani dan transaksi dicatat.");
    }

    public static void cekSisaAntrian() {
        System.out.println(">> Sisa pasien dalam antrian: " + antrianPasien.size());
    }

    public static void lihatRiwayat() {
        if (riwayatTransaksi.isEmpty()) {
            System.out.println(">> Belum ada transaksi.");
        } else {
            riwayatTransaksi.printAll();
        }
    }
}
