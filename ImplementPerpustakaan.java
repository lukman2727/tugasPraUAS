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

import ib.perpustakaan.data.entity.Perpustakaan;
import ib.perpustakaan.lib.Koneksi3;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ib.perpustakaan.data.interfc.InterfacePerpustakaan;

/**
 *
 * @author Iyongb
 */
public class ImplementPerpustakaan implements InterfacePerpustakaan{

    @Override
    public List getBuku() throws SQLException { 
        String sql = "SELECT b.*, dp.Status, dp.NoPinjam "
                + "FROM buku AS b "
                + "LEFT JOIN (SELECT * FROM detailpinjam WHERE detailpinjam.STATUS = '0') dp ON (b.KodeBuku = dp.KodeBuku) "
                + "ORDER BY b.KodeBuku ASC";
        PreparedStatement st = Koneksi3.getConnection().prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        List list = new ArrayList();
        while(rs.next()){
            Perpustakaan o = new Perpustakaan();
            o.setKodeBuku(rs.getString("KodeBuku"));
            o.setJudul(rs.getString("Judul"));
            o.setPengarang(rs.getString("Pengarang"));
            o.setPenerbit(rs.getString("Penerbit"));
            o.setTahunTerbit(rs.getString("TahunTerbit"));
            String status = rs.getString("Status");
            try{
                if(status.equals("0")) status = "0";
            }catch(NullPointerException npe){
                status = "Ada";
            }
            o.setStatus(status);
            o.setNoPinjam(rs.getString("NoPinjam"));
            list.add(o);
        }
        return list;
    }

    @Override
    public List cariBuku(String cari) throws SQLException {
        if(cari.equals(""))
        {
            return getBuku();
        }
        else
        {
            String sql = "SELECT b.*, dp.Status, dp.NoPinjam "
                    + "FROM buku AS b "
                    + "LEFT JOIN (SELECT * FROM detailpinjam WHERE detailpinjam.STATUS = '0') dp ON (b.KodeBuku = dp.KodeBuku) "
                    + "WHERE b.KodeBuku LIKE ? OR b.Judul LIKE ? OR b.Pengarang LIKE ? OR b.penerbit LIKE ? OR b.TahunTerbit = ? "
                    + "ORDER BY b.KodeBuku ASC";
            PreparedStatement st = Koneksi3.getConnection().prepareStatement(sql);
            st.setString(1, "%" + cari + "%");
            st.setString(2, "%" + cari + "%");
            st.setString(3, "%" + cari + "%");
            st.setString(4, "%" + cari + "%");
            st.setString(5, cari);
            
            ResultSet rs = st.executeQuery();
            List list = new ArrayList();
            while(rs.next()){
                Perpustakaan o = new Perpustakaan();
                o.setKodeBuku(rs.getString("KodeBuku"));
                o.setJudul(rs.getString("Judul"));
                o.setPengarang(rs.getString("Pengarang"));
                o.setPenerbit(rs.getString("Penerbit"));
                o.setTahunTerbit(rs.getString("TahunTerbit"));
                String status = rs.getString("Status");
                try{
                    if(status.equals("0")) status = "0";
                }catch(NullPointerException npe){
                    status = "Ada";
                }
                o.setStatus(status);
                o.setNoPinjam(rs.getString("NoPinjam"));
                list.add(o);
            }
            return list;
        }
    }
    
}
