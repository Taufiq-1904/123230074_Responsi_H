/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Shop;
import model.ShopDAO;
import view.ShopForm;

/**
 *
 * @author Lab Informatika
 */
public class ShopController {
    private ShopDAO dao;
    private ShopForm view;
    
    public ShopController(ShopDAO dao, ShopForm view){
        this.dao = dao;
        this.view = view;
        view.setController(this);
        view.setVisible(true);
        view.showShop(dao.getAll());
    }
    
    public void addShop(Shop shop){
        dao.insert(shop);
        view.showShop(dao.getAll());
    }
    
    public void updateShop(Shop shop){
        dao.update(shop);
        view.showShop(dao.getAll());
    }
    
    public void deleteShop(Shop shop){
        dao.delete(shop);
        view.showShop(dao.getAll());
    }
}
