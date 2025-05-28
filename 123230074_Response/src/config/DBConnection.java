/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import java.sql.*;
/**
 *
 * @author Lab Informatika
 */
public class DBConnection {
    private static Connection conn;
    
    public static Connection getConnection() {
        if (conn  == null){
            try {
                String url = "jdbc:mysql://localhost:3306/shop_db";
                String user = "root";
                String pass = "";
                conn = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                System.out.println("Koneksi gagal: " + e.getMessage());
            }
        }
        return conn;
    }
}
