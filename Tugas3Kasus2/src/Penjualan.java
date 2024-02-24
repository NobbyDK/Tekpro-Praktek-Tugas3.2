import java.util.List;

/**
 * <TUGAS 3 kasus 2 Object Class Encapsulation>
 * Author  : Nobby Dharma Khaulid
 * NIM     : 231524020
 * Tanggal : 24 Februari 2024
 */

public class Penjualan {
    private Produk[] nama_produk;
    private int quantity;
    private int harga_total;


    //Constructor untuk membuat objek Penjualan dengan jumlah maksimum Produk tertentu
    public Penjualan(int maxProduk) {
    nama_produk = new Produk[maxProduk]; //Inisialisasi array daftarProduk
    quantity = 0; //Set jumlah Produk awal menjadi 0
    }

    //Metode untuk menambahkan produk ke dalam class MiniMarket
    public void tambahProduk(Produk Produk) {
        //Cek apakah masih ada tempat kosong untuk menambahkan produk baru
        if (quantity < nama_produk.length) {
            nama_produk[quantity] = Produk; //Menambahkan Produk ke dalam array
            quantity++; //Menambahkan jumlah Produk
        } else {
            System.out.println("Maaf, jumlah maksimum Produk telah tercapai.");
        }
    }

    //Procedure untuk menampilkan Produk makanan yang tersedia di MiniMarket
    public void tampilProdukList() {
        System.out.println("\n\tMenu Makanan ");
        System.out.println("========================================");
        for (int i = 0; i < quantity; i++) {
            if (!nama_produk[i].isOutOfStock()) { //Kondisi untuk mengecek apakah stok masih tersedia atau sudah habis
                //menampilkan nama Produk, Quantity, dan harga
                System.out.println(nama_produk[i].getNama_Produk() + "[" + nama_produk[i].getQty() + "]" + "\tRp. " + nama_produk[i].getHarga());
            }   
        }
    }

     // Metode untuk memesan Produk
    public void pesanProduk(String namaProduk, int jumlahPesan) {
        for (int i = 0; i < quantity; i++) {
            if (nama_produk[i].getNama_Produk().equalsIgnoreCase(namaProduk)) {
                if (nama_produk[i].getQty() >= jumlahPesan) {
                    nama_produk[i].SisaQuantity(jumlahPesan);
                    System.out.println("Pemesanan berhasil!");
                    System.out.println("Total Harga Produk : " + (nama_produk[i].getHarga() * jumlahPesan));
                    System.out.println("Stok yang tersedia " +nama_produk[i].getNama_Produk()+ ":" +nama_produk[i].getQty());
                    return;
                } 
                else {
                    System.out.println("Maaf, stok tidak mencukupi untuk pemesanan ini.");
                    return;
                }
            }
        }
        System.out.println("Menu tidak ditemukan.");
    }

    //fungsi untuk mengembalikan harga produk
    public int getHargaProduk(String namaProduk) {
        for (int i = 0; i < quantity; i++) {
            if (nama_produk[i].getNama_Produk().equalsIgnoreCase(namaProduk)) {
                return nama_produk[i].getHarga();
            }
        }
        return -1; // Return -1 jika nama produk tidak ditemukan
    }

    //Fungsi untuk Mengakumulasikan total pembayaran produk yang dibeli oleh pembeli
    public int totalpembayaran(List<PesananPembeli> daftarPesanan) {
        int total = 0;
        for (PesananPembeli pesanan : daftarPesanan) {
            int hargaProduk = getHargaProduk(pesanan.getNamaProduk());
            total += hargaProduk * pesanan.getJumlahPesan();
        }
        System.out.println("Total Pembayaran Keseluruhan : Rp " + total);
        System.out.println("Terimakasih telah memesan dan selamat menikmati");
        return total;
    }
    
    //Prosedur untuk menampilkan rincian akumulasi produk yang dibeli oleh pembeli
    public void tampilkanRincianPesanan(List<PesananPembeli> daftarPesanan) {
        if (daftarPesanan.isEmpty()) {
            System.out.println("Belum ada pesanan.");
        } else {
            for (PesananPembeli pesanan : daftarPesanan) {
                String namaProduk = pesanan.getNamaProduk();
                int jumlahPesan = pesanan.getJumlahPesan();
                int hargaProduk = getHargaProduk(namaProduk);
                int totalHargaPesanan = hargaProduk * jumlahPesan;

                System.out.println(namaProduk + "\t\t " + jumlahPesan + " buah" + "\t\t " + "Rp. " + totalHargaPesanan);
            }
        }
    }
}
