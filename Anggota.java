/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ib.perpustakaan.data.entity;

/**
 *
 * @author Iyongb
 */
public class Anggota {
    public static String tabel = "anggota";
    
    private int row_execute;
    
    private String NoAnggota;
    private String Nama;
    private String Alamat;

    public int getRow_execute() {
        return row_execute;
    }

    public void setRow_execute(int aRow_execute) {
        row_execute = aRow_execute;
    }

    public String getNoAnggota() {
        return NoAnggota;
    }

    public void setNoAnggota(String aNoAnggota) {
        NoAnggota = aNoAnggota;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String aNama) {
        Nama = aNama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String aAlamat) {
        Alamat = aAlamat;
    }
}
