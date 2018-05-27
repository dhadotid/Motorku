package com.rsypj.motorku.model;

/**
 * Created by dhadotid on 16/03/2018.
 */

public class TransactionModel {

    int id;
    String namaSparepart;
    int harga;

    public TransactionModel(int id, String namaSparepart, int harga) {
        this.id = id;
        this.namaSparepart = namaSparepart;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public String getNamaSparepart() {
        return namaSparepart;
    }

    public int getHarga() {
        return harga;
    }
}
