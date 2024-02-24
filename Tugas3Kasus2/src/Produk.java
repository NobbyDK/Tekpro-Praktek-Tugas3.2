/**
 * <TUGAS 3 kasus 2 Object Class Encapsulation>
 * Author  : Nobby Dharma Khaulid
 * NIM     : 231524020
 * Tanggal : 24 Februari 2024
 */

public class Produk {   //mendeklarasikan class Produk
    private String nama_Produk;
    private int harga;
    private int qty;

    public Produk (String nama_Produk, int harga, int qty){     //constructors untuk membuat objek produk
        this.nama_Produk = nama_Produk; //Nama produk
        this.harga = harga; //Harga Produk
        this.qty = qty; //Jumlah Stok Produk
    }

    public String getNama_Produk() {
        return nama_Produk;
    }

    public int getHarga() {
        return harga;
    }

    public int getQty() {
        return qty;
    }

    public boolean isOutOfStock(){      //Fungsi untuk mengecek apakah stok produk habis
        return qty == 0;
    }

    public void SisaQuantity(int jumlah){       //Prosedur untuk mengurangi stok produk setelah pembelian

        qty -= jumlah;
    }
}
