public class Pasien {
    String nama, nik, keluhan;

    public Pasien(String nama, String nik, String keluhan) {
        this.nama = nama;
        this.nik = nik;
        this.keluhan = keluhan;
    }

    public void tampilkanInformasi() {
        System.out.println(
            "Nama pasien: " + nama + "\n" +
            "NIK: " + nik + "\n" +
            "Keluhan: " + keluhan + "\n"
        );
    }
}
