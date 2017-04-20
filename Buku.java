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
package ib.perpustakaan.data.entity;

/**
 *
 * @author Iyongb
 */
public class Buku {
    public static String tabel = "buku";
    
    private int row_execute;
    private String KodeBuku;
    private String Judul;
    private String Pengarang;
    private String Penerbit;
    private String TahunTerbit;

    public int getRow_execute() {
        return row_execute;
    }

    public void setRow_execute(int row_execute) {
        this.row_execute = row_execute;
    }

    public String getKodeBuku() {
        return KodeBuku;
    }

    public void setKodeBuku(String KodeBuku) {
        this.KodeBuku = KodeBuku;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

    public String getPengarang() {
        return Pengarang;
    }

    public void setPengarang(String Pengarang) {
        this.Pengarang = Pengarang;
    }

    public String getPenerbit() {
        return Penerbit;
    }

    public void setPenerbit(String Penerbit) {
        this.Penerbit = Penerbit;
    }

    public String getTahunTerbit() {
        return TahunTerbit;
    }

    public void setTahunTerbit(String TahunTerbit) {
        this.TahunTerbit = TahunTerbit;
    }
}
