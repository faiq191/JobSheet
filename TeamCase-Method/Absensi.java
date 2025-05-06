public class Absensi {
    Mahasiswa mahasiswa;
    MataKuliah mataKuliah;
    int hadir;
    int sakit;
    int izin;
    int alpa;

    public Absensi(Mahasiswa mahasiswa, MataKuliah mataKuliah, int hadir, int sakit, int izin, int alpa) {
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.hadir = hadir;
        this.sakit = sakit;
        this.izin = izin;
        this.alpa = alpa;
    }

    public double hitungPersentaseKehadiran() {
        int totalPertemuan = hadir + sakit + izin + alpa;
        if (totalPertemuan == 0) {
            return 0.0;
        }
        return (double) hadir / totalPertemuan * 100;
    }

    public void tampilData() {
        System.out.println("Mahasiswa: " + mahasiswa.namaMahasiswa);
        System.out.println("NIM: " + mahasiswa.nim);
        System.out.println("Mata Kuliah: " + mataKuliah.namaMK);
        System.out.println("Kode MK: " + mataKuliah.kodeMK);
        System.out.println("SKS: " + mataKuliah.sks);
        System.out.println("Hadir: " + hadir);
        System.out.println("Sakit: " + sakit);
        System.out.println("Izin: " + izin);
        System.out.println("Alpa: " + alpa);
        System.out.println("Persentase Kehadiran: " + String.format("%.2f", hitungPersentaseKehadiran()) + "%");
        System.out.println("----------------------------------------");
    }
}
