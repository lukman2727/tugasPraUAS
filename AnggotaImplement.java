/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ib.perpustakaan.data.implement;

import ib.perpustakaan.data.entity.Anggota;
import ib.perpustakaan.data.interfc.AnggotaInterface;
import ib.perpustakaan.lib.Koneksi3;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Iyongb
 */
public class AnggotaImplement implements AnggotaInterface{

    @Override
    public Anggota insert(Anggota o) throws SQLException {
        PreparedStatement st = Koneksi3.getConnection().prepareStatement("INSERT INTO "+Anggota.tabel+"(NoAnggota, Nama, Alamat) values(?, ?, ?)");
        st.setString(1, o.getNoAnggota());
        st.setString(2, o.getNama());
        st.setString(3, o.getAlamat());
        o.setRow_execute(st.executeUpdate());
        return o;
    }

    @Override
    public Anggota update(Anggota o) throws SQLException {
        PreparedStatement st = Koneksi3.getConnection().prepareStatement("UPDATE "+Anggota.tabel+" SET Nama = ?, Alamat = ? WHERE NoAnggota = ?");
        st.setString(1, o.getNama());
        st.setString(2, o.getAlamat());
        st.setString(3, o.getNoAnggota());
        o.setRow_execute(st.executeUpdate());
        return o;
    }

    @Override
    public int delete(String id_anggota) throws SQLException {
        PreparedStatement st = Koneksi3.getConnection().prepareStatement("DELETE FROM "+Anggota.tabel+" WHERE NoAnggota = ?");
        st.setString(1, id_anggota);
        return st.executeUpdate();
    }

    @Override
    public List getAnggota() throws SQLException {
        Statement st = Koneksi3.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM "+Anggota.tabel);
        List list = new ArrayList();
        while(rs.next()){
            Anggota o = new Anggota();
            o.setNoAnggota(rs.getString("NoAnggota"));
            o.setNama(rs.getString("Nama"));
            o.setAlamat(rs.getString("Alamat"));
            list.add(o);
        }
        return list;
    }

    @Override
    public List cariAnggota(int pilih, String cari) throws SQLException {
        String sql = "";
        if (pilih == 0) {
            sql = "Select * from "+Anggota.tabel+" WHERE NoAnggota ='" + cari + "'";
        } else {
            sql = "Select * from "+Anggota.tabel+" WHERE Nama Like '%" + cari + "%'";
        }
        Statement st = Koneksi3.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        List list = new ArrayList();
        while(rs.next()){
            Anggota o = new Anggota();
            o.setNoAnggota(rs.getString("NoAnggota"));
            o.setNama(rs.getString("Nama"));
            o.setAlamat(rs.getString("Alamat"));
            list.add(o);
        }
        return list;
    }
    
}
