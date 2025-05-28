/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;

/**
 *
 * @author Lab Informatika
 */
public interface ShopInterface {
    void insert(Shop shop);
    void update(Shop shop);
    void delete(Shop orang);
    List<Shop> getAll();
}
