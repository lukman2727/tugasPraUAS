/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ib.perpustakaan.data.interfc;

import ib.perpustakaan.data.entity.Anggota;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Iyongb
 */
public interface AnggotaInterface {
    Anggota insert(Anggota o) throws SQLException;
    Anggota update(Anggota o) throws SQLException;
    int delete (String id_anggota) throws SQLException;
    List getAnggota() throws SQLException;
    List cariAnggota(int pilih, String cari) throws SQLException;
}
