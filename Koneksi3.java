package ib.perpustakaan.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Koneksi3 {
    
    private static Connection conn;

    public static Connection getConnection(){
        if(conn==null){
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(Koneksi1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }
}
