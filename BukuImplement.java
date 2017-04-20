/*
 * Copyright (C) 2016 Iyongb
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ib.perpustakaan.data.implement;

import ib.perpustakaan.data.entity.Buku;
import ib.perpustakaan.data.interfc.BukuInterface;
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
public class BukuImplement implements BukuInterface{

    @Override
    public Buku insert(Buku o) throws SQLException {
        PreparedStatement st = Koneksi3.getConnection().prepareStatement("INSERT INTO "+Buku.tabel+" values(?, ?, ?, ?, ?)");
        st.setString(1, o.getKodeBuku());
        st.setString(2, o.getJudul());
        st.setString(3, o.getPengarang());
        st.setString(4, o.getPenerbit());
        st.setString(5, o.getTahunTerbit());
        o.setRow_execute(st.executeUpdate());
        return o;
    }

    @Override
    public Buku update(Buku o) throws SQLException {
        PreparedStatement st = Koneksi3.getConnection().prepareStatement("UPDATE "+Buku.tabel+" SET Judul = ?, Pengarang = ?, Penerbit = ?, TahunTerbit = ? WHERE KodeBuku = ?");
        st.setString(1, o.getJudul());
        st.setString(2, o.getPengarang());
        st.setString(3, o.getPenerbit());
        st.setString(4, o.getTahunTerbit());
        st.setString(5, o.getKodeBuku());
        o.setRow_execute(st.executeUpdate());
        return o;
    }

    @Override
    public int delete(String id_buku) throws SQLException {
        PreparedStatement st = Koneksi3.getConnection().prepareStatement("DELETE FROM "+Buku.tabel+" WHERE KodeBuku = ?");
        st.setString(1, id_buku);
        PreparedStatement st2 = Koneksi3.getConnection().prepareStatement("DELETE FROM detailpinjam WHERE KodeBuku = ?");
        st2.setString(1, id_buku);
        return st.executeUpdate();
    }

    @Override
    public List getBuku() throws SQLException {
        Statement st = Koneksi3.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM "+Buku.tabel);
        List list = new ArrayList();
        while(rs.next()){
            Buku o = new Buku();
            o.setKodeBuku(rs.getString("KodeBuku"));
            o.setJudul(rs.getString("Judul"));
            o.setPengarang(rs.getString("Pengarang"));
            o.setPenerbit(rs.getString("Penerbit"));
            o.setTahunTerbit(rs.getString("TahunTerbit"));
            list.add(o);
        }
        return list;
    }

    @Override
    public List cariBuku(int pilih, String cari) throws SQLException {
        String sql = "";
        switch(pilih)
        {
            case 0:
                sql = "Select * from Buku WHERE Judul Like '%" + cari + "%'";
                break;
            case 1:
                sql = "Select * from Buku WHERE Pengarang Like '%" + cari + "%'";
                break;
            case 2:
                sql = "Select * from Buku WHERE Penerbit Like '%" + cari + "%'";
                break;
            default:
                sql = "Select * from Buku WHERE TahunTerbit = '" + cari + "'";
                break;
        }
        Statement st = Koneksi3.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        List list = new ArrayList();
        while(rs.next()){
            Buku o = new Buku();
            o.setKodeBuku(rs.getString("KodeBuku"));
            o.setJudul(rs.getString("Judul"));
            o.setPengarang(rs.getString("Pengarang"));
            o.setPenerbit(rs.getString("Penerbit"));
            o.setTahunTerbit(rs.getString("TahunTerbit"));
            list.add(o);
        }
        return list;
    }
    
}
