import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <TUGAS 3 kasus 2 Object Class Encapsulation>
 * Author  : Nobby Dharma Khaulid
 * NIM     : 231524020
 * Tanggal : 24 Februari 2024
 */

public class MiniMarket {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        
        Penjualan Produk = new Penjualan(10);          //Membuat objek Penjualan dengan kapasitas maksimum 10 produk

        //List produk
        Produk.tambahProduk(new Produk("Lays", 28_000, 100));
        Produk.tambahProduk(new Produk("Chitato", 17_000, 100));
        Produk.tambahProduk(new Produk("Tango", 10_000, 100));
        Produk.tambahProduk(new Produk("Oreo", 11_000, 100));
        Produk.tambahProduk(new Produk("Pocky", 9_000, 100));
        Produk.tambahProduk(new Produk("Twister", 13_000, 100));
        Produk.tambahProduk(new Produk("Freshtea", 8_000, 100));
        Produk.tambahProduk(new Produk("Air Mineral", 3_000, 100));
        Produk.tambahProduk(new Produk("Fanta", 12_000, 100));
        Produk.tambahProduk(new Produk("Nescafe", 7_000, 100));

        // Membuat daftar untuk menyimpan pesanan pembeli
        List<PesananPembeli> daftarPesanan = new ArrayList<>();

        char pesanLagi;
        do {                // Loop untuk memesan produk secara berulang
            System.out.println("\n");
            Produk.tampilProdukList(); // Menampilkan Produk yang tersedia di MiniMarket
            System.out.println("\n");
            System.out.println("\tPesanan yang akan Dipesan");
            System.out.println("========================================");
            System.out.print("Masukkan nama Produk yang ingin dipesan: ");
            String namaMenu = input.nextLine();
            System.out.print("Masukkan jumlah yang ingin dipesan: ");
            int jumlahPesan = input.nextInt();
            input.nextLine(); // Membersihkan newline di buffer

            Produk.pesanProduk(namaMenu, jumlahPesan);    // Memesan Produk berdasarkan nama dan jumlah yang dimasukkan pengguna

            daftarPesanan.add(new PesananPembeli(namaMenu, jumlahPesan));    // Menambahkan pesanan pembeli ke dalam daftarPesanan

            System.out.print("Ingin memesan lagi? (y/n): ");
            pesanLagi = input.nextLine().charAt(0);

        } while (pesanLagi == 'y' || pesanLagi == 'Y');

        System.out.println("\n"); 
        System.out.println("\t Rincian Pesanan");
        System.out.println("========================================"); 
        Produk.tampilkanRincianPesanan( daftarPesanan);
        Produk.totalpembayaran(daftarPesanan );          // Menampilkan total pembayaran untuk semua pesanan
        input.close();
    }
}



