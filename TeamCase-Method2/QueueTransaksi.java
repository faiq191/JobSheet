import java.util.ArrayList;

public class QueueTransaksi {
    ArrayList<TransaksiLayanan> transaksiList = new ArrayList<>();

    public void addTransaction(TransaksiLayanan transaksi) {
        transaksiList.add(transaksi);
    }

    public void printTransactions() {
        if (transaksiList.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            System.out.println("-- Riwayat Transaksi --");
            for (TransaksiLayanan transaksi : transaksiList) {
                transaksi.tampilkanTransaksi();
            }
        }
    }
}
