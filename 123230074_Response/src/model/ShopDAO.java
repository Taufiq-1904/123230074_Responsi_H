/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.DBConnection;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Lab Informatika
 */
public class ShopDAO implements ShopInterface{
    Connection conn;
    public ShopDAO(){
        conn = DBConnection.getConnection();
    }
    
    public void insert(Shop shop) {
        try {
            String sql = "INSERT INTO shop VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, shop.getOrang());
            ps.setString(2, shop.getKucing());
            ps.setInt(3, shop.getNumber());
            ps.setDouble(4, shop.getDay());
            ps.setDouble(5, shop.getPrice());
            ps.executeUpdate();
            System.out.println("Kucing berhasil ditambahkan.");
        } catch (SQLException e){
            System.out.println("Gagal menambahkan kucing: " + e.getMessage());
        }
    }
    
    public void update(Shop shop) {
        try {
            String sql = "UPDATE shop SET kucing=?, number=?, day=?, price=? WHERE orang=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, shop.getOrang());
            ps.setString(2, shop.getKucing());
            ps.setInt(3, shop.getNumber());
            ps.setDouble(4, shop.getDay());
            ps.setDouble(5, shop.getPrice());
            ps.executeUpdate();
            System.out.println("Kucing berhasil diupdate.");
        } catch (SQLException e){
            System.out.println("Gagal update: " + e.getMessage());
        }
    }
    
    public void delete(String orang){
        try {
            String sql = "DLETE FROM shop WHERE orang=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, orang);
            ps.executeUpdate();
            System.out.println("Kucing berhasil dihapus");
        } catch (SQLException e) {
            System.out.println("Gagal hapus: " + e.getMessage());
        }
    }
    
    public List<Shop> getAll() {
        List<Shop> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM shop";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Shop s = new Shop(
                        rs.getString("orang"),
                        rs.getString("kucing"),
                        rs.getInt("number"),
                        rs.getDouble("day")
                );
                list.add(s);
                }
            } catch (SQLException e){
                System.out.println("Gagal mengambil data: " + e.getMessage());    
            }
            return list;
        }

    @Override
    public void delete(Shop orang) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
