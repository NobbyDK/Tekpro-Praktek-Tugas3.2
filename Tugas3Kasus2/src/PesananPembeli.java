/**
 * <TUGAS 3 kasus 2 Object Class Encapsulation>
 * Author  : Nobby Dharma Khaulid
 * NIM     : 231524020
 * Tanggal : 24 Februari 2024
 */

public class PesananPembeli {   //mendeklarasikan class PesananPembeli
    private String namaProduk;
    private int jumlahPesan;

    public PesananPembeli(String namaProduk, int jumlahPesan) { //Constructors untuk objek Pesananpembeli
        this.namaProduk = namaProduk;   
        this.jumlahPesan = jumlahPesan;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public int getJumlahPesan() {
        return jumlahPesan;
    }
}

//class ini dibuat untuk merekap inputan pembelian dari pihak pembeli supaya memudahkan dalam 
//merekap data keseluruhan dan menghitung total pembayaran