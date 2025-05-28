/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ShopController;
import model.Shop;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;
/**
 *
 * @author Lab Informatika
 */
public class ShopForm extends JFrame{
    private ShopController controller;
    private JTextField txtOrang, txtKucing, txtNumber, txtDay, txtPrice;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnTambah, btnUbah, btnHapus, btnClear;
    
    public ShopForm(){
        setTitle("CattyCare- Aplikasi Penitipan Kucing");
        setSize(900, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JLabel lblOrang = new JLabel("Nama Pemilik");
        JLabel lblKucing = new JLabel("Nama Kucing");
        JLabel lblNumber = new JLabel("Nomer Telepon");
        JLabel lblDay = new JLabel("Lama Pentitipan(Hari)");
        
        txtOrang = new JTextField();
        txtKucing = new JTextField();
        txtNumber = new JTextField();
        txtDay = new JTextField();
        
        lblOrang.setBounds(670, 30, 100, 20);
        txtOrang.setBounds(770, 30, 100, 20);
        lblKucing.setBounds(670, 60, 100, 20);
        txtKucing.setBounds(770, 60, 100, 20);
        lblNumber.setBounds(670, 90, 100, 20);
        txtNumber.setBounds(770, 90, 100, 20);
        lblDay.setBounds(670, 120, 100, 20);
        txtDay.setBounds(770, 120, 100, 20);
        
        add(lblOrang); add(txtOrang);
        add(lblKucing); add(txtKucing);
        add(lblNumber); add(txtNumber);
        add(lblDay); add(txtDay);
        
        //Tombol
        btnTambah = new JButton("Tambah");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");
        
        btnTambah.setBounds(670, 220, 90, 25);
        btnUbah.setBounds(770, 220, 90, 25);
        btnHapus.setBounds(670, 250, 90, 25);
        btnClear.setBounds(770, 250, 90, 25);
        
        add(btnTambah); add(btnUbah); add(btnHapus); add(btnClear);
        
        //Tabel
        tableModel = new DefaultTableModel(new Object[]{"Nama Pemilik", "Nama Kucing", "Nomor Telepon", "Lama Penitipan", "Biaya"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 620, 300);
        add(scrollPane);
        
        btnTambah.addActionListener(e -> {controller.addShop(getShopFromForm());
        showMessage("Data Kucing berhasil ditambahkan");
        clearForm();
        });
        btnUbah.addActionListener(e -> controller.updateShop(getShopFromForm()));
        btnHapus.addActionListener(e -> controller.deleteShop(getShopFromForm()));
        btnUbah.addActionListener(e -> clearForm());
        
        table.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
            int row = table.getSelectedRow();
            txtOrang.setText(tableModel.getValueAt(row, 0).toString());
            txtKucing.setText(tableModel.getValueAt(row, 1).toString());
            txtNumber.setText(tableModel.getValueAt(row, 2).toString());
            txtDay.setText(tableModel.getValueAt(row, 3).toString());
        }
    });
}
    
    public void setController(ShopController controller){
        this.controller = controller;
    }
    
public void showShop(List<Shop> shop){
    tableModel.setRowCount(0);
    for (Shop s : shop) {
        tableModel.addRow(new Object[]{
           s.getOrang(), s.getKucing(), s.getNumber(), s.getDay(),
           String.format("%.2f", s.getPrice())
        });
    }
}

public Shop getShopFromForm() {
    String orang = txtOrang.getText();
    String kucing = txtKucing.getText();
    int number = Integer.parseInt(txtNumber.getText());
    double day = Double.parseDouble(txtDay.getText());
    return new Shop(orang, kucing, number, day);
}

public void showMessage(String msg){
    JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
}

public void clearForm(){
    txtOrang.setText("");
    txtKucing.setText("");
    txtNumber.setText("");
    txtDay.setText("");
}

}