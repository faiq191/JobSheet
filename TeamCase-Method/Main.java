import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Mahasiswa[] mahasiswaList = {
                new Mahasiswa("22001", "Ali Rahman"),
                new Mahasiswa("22002", "Budi Santoso"),
                new Mahasiswa("22003", "Citra Dewi"),
                new Mahasiswa("22004", "Deni Saputra"),
                new Mahasiswa("22005", "Eka Wulandari"),
        };

        MataKuliah[] mataKuliahList = {
                new MataKuliah("MK001", "Struktur Data", 3),
                new MataKuliah("MK002", "Basis Data", 3),
                new MataKuliah("MK003", "Desain Web", 2),
        };

        Absensi[] absensiList = {
                new Absensi(mahasiswaList[0], mataKuliahList[0], 10, 1, 1, 0),
                new Absensi(mahasiswaList[0], mataKuliahList[1], 12, 0, 1, 1),
                new Absensi(mahasiswaList[1], mataKuliahList[0], 14, 0, 0, 0),
                new Absensi(mahasiswaList[2], mataKuliahList[1], 9, 2, 1, 2),
                new Absensi(mahasiswaList[2], mataKuliahList[2], 10, 0, 0, 2),
                new Absensi(mahasiswaList[3], mataKuliahList[2], 13, 0, 0, 0),
                new Absensi(mahasiswaList[4], mataKuliahList[0], 11, 1, 1, 1),
        };

        int choice;
        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Tampilkan Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mata Kuliah");
            System.out.println("3. Tampilkan Data Absensi");
            System.out.println("4. Urutkan Berdasarkan Persentase Kehadiran (Desc)");
            System.out.println("5. Cari Data Absensi Berdasarkan NIM");
            System.out.println("6. Rangkuman Data Per Mata Kuliah");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("=== DATA MAHASISWA ===");
                    for (Mahasiswa m : mahasiswaList) {
                        m.tampilData();
                    }
                }
                case 2 -> {
                    System.out.println("=== DATA MATA KULIAH ===");
                    for (MataKuliah mk : mataKuliahList) {
                        System.out.println("Kode MK: " + mk.kodeMK + " | Nama: " + mk.namaMK + " | SKS: " + mk.sks);
                    }
                }
                case 3 -> {
                    System.out.println("=== DATA ABSENSI MAHASISWA ===");
                    for (Absensi abs : absensiList) {
                        System.out.println("NIM: " + abs.mahasiswa.nim + " | Nama: " + abs.mahasiswa.namaMahasiswa);
                        System.out.println("Mata Kuliah: " + abs.mataKuliah.namaMK);
                        System.out.printf("Hadir: %d | Sakit: %d | Izin: %d | Alpa: %d%n",
                                abs.hadir, abs.sakit, abs.izin, abs.alpa);
                        System.out.printf("Persentase Kehadiran: %.2f%%%n", abs.hitungPersentaseKehadiran());
                        System.out.println();
                    }
                }
                case 4 -> {
                    System.out.println("=== DATA ABSENSI BERDASARKAN PERSENTASE KEHADIRAN ===");

                    for (int i = 0; i < absensiList.length - 1; i++) {
                        for (int j = 0; j < absensiList.length - i - 1; j++) {
                            if (absensiList[j].hitungPersentaseKehadiran() < absensiList[j + 1]
                                    .hitungPersentaseKehadiran()) {
                                Absensi temp = absensiList[j];
                                absensiList[j] = absensiList[j + 1];
                                absensiList[j + 1] = temp;
                            }
                        }
                    }

                    for (Absensi abs : absensiList) {
                        System.out.printf("%.2f%% - %s - %s%n",
                                abs.hitungPersentaseKehadiran(),
                                abs.mahasiswa.namaMahasiswa,
                                abs.mataKuliah.namaMK);
                    }
                }
                case 5 -> {
                    System.out.print("Input: ");
                    String inputNIM = scanner.nextLine();
                    boolean found = false;
                    System.out.println("=== HASIL PENCARIAN ABSENSI MAHASISWA ===");
                    for (Absensi abs : absensiList) {
                        if (abs.mahasiswa.nim.equals(inputNIM)) {
                            System.out.println("NIM: " + abs.mahasiswa.nim + " | Nama: " + abs.mahasiswa.namaMahasiswa);
                            System.out.println("Mata Kuliah: " + abs.mataKuliah.namaMK);
                            System.out.printf("Hadir: %d | Sakit: %d | Izin: %d | Alpa: %d%n",
                                    abs.hadir, abs.sakit, abs.izin, abs.alpa);
                            System.out.printf("Persentase Kehadiran: %.2f%%%n", abs.hitungPersentaseKehadiran());
                            System.out.println();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Data absensi untuk NIM \"" + inputNIM + "\" tidak ditemukan.");
                    }
                }
                case 6 -> {
                    System.out.println("=== RANGKUMAN DATA PER MATA KULIAH ===");
                    for (MataKuliah mk : mataKuliahList) {
                        int hadir = 0;
                        double totalPertemuan = 0;
                        int jumlahMahasiswaTidakLulus = 0;

                        for (Absensi abs : absensiList) {
                            if (abs.mataKuliah.kodeMK.equals(mk.kodeMK)) {
                                double persen = abs.hitungPersentaseKehadiran();
                                totalPertemuan += persen;
                                hadir++;

                                if (persen < 75) {
                                    jumlahMahasiswaTidakLulus++;
                                }

                            }
                        }
                        if (hadir > 0) {
                            double rataRataPersentase = totalPertemuan / hadir;
                            System.out.printf("Mata Kuliah: %s Rata-Rata Kehadiran: %.2f%%%n", mk.namaMK,
                                    rataRataPersentase);
                            System.out.printf("Mahasiswa Tidak Lulus: %d orang%n%n", jumlahMahasiswaTidakLulus);
                        }
                    }
                }
                case 0 -> System.out.println("Program selesai.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }
}
